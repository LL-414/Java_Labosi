package hr.java.production.main;

import hr.java.production.model.*;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private static final Integer NUM_CATEGORIES = 3;
    private static final Integer NUM_ITEMS = 5;
    private static final Integer NUM_FACTORIES = 2;
    private static final Integer NUM_STORES = 2;
    static Scanner scanner = new Scanner(System.in);

    private static String biggestVolume(Factory[] factories) {
        String biggestFactory = null;
        BigDecimal biggestVolume = BigDecimal.ZERO;

        for (int i = 0; i < factories.length; i++) {
            BigDecimal factoryVolume = BigDecimal.ZERO;

            for (int j = 0; j < factories[i].getItems().length; j++) {
                Item tmpItem = factories[i].getItems()[j];

                // Null check before accessing properties of tmpItem
                if (tmpItem != null) {
                    BigDecimal itemVolume = tmpItem.getWidth().multiply(tmpItem.getHeight()).multiply(tmpItem.getLength());
                    factoryVolume = factoryVolume.add(itemVolume);
                }
            }

            if (factoryVolume.compareTo(biggestVolume) > 0) {
                biggestVolume = factoryVolume;
                biggestFactory = factories[i].getName();
            }
        }

        return biggestFactory;
    }

    private static String cheapestStore(Store[] stores) {
        String cheapestStore = null;
        BigDecimal cheapestPrice = BigDecimal.valueOf(Double.MAX_VALUE);

        for (int i = 0; i < stores.length; i++) {
            Item[] items = stores[i].getItems();

            for (int j = 0; j < items.length; j++) {
                BigDecimal itemPrice = items[j].getSellingPrice();

                // Null check before accessing getSellingPrice()
                if (itemPrice != null) {
                    if (itemPrice.compareTo(cheapestPrice) < 0) {
                        cheapestPrice = itemPrice;
                        cheapestStore = stores[i].getName();
                    }
                }
            }
        }

        return cheapestStore;
    }

    public static int scanInt(int min, int max) {
        Integer choice;

        while (true) {

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Krivi unos molimo ponovite!");
                    scanner.nextLine();
                }

            } else {
                System.out.println("Krivi unos molimo ponovite!");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static BigDecimal scanBigDecimal() {
        BigDecimal inputBigDecimal;
        while (true) {
            if (scanner.hasNextBigDecimal()) {
                inputBigDecimal = scanner.nextBigDecimal();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Krivi unos molimo ponovite!");
            }
        }
        return inputBigDecimal;
    }
//________________________________________________________________
    public static Item findMostExpensiveFood(Item[] items) {
        BigDecimal maxPrice = BigDecimal.ZERO;
        Item mostExpensiveFood = null;

        for (Item item : items) {
            // Check if the item is an edible
            if (item instanceof Edible) {

            }
        }

        return mostExpensiveFood;
    }

    public static Item findMostCaloricFood(Item[] items) {
        int maxCalories = 0;
        Item mostCaloricFood = null;

        for (Item item : items) {
            // Check if the item is an edible
            if (item instanceof Edible) {

            }
        }

        return mostCaloricFood;
    }
//_______________________________________________________________________
    public static boolean selectFood() {
        System.out.println("Zelite li birati artikle ili izabrati hranu?");
        System.out.println("Hrana|1|--Ostali artikli|2|");
        while (true) {
            if (scanInt(1, 2) == 1) {
                return true;
            } else {
                return false;
            }
        }
    }


    //napisati metodu za hranu sa najvise kalorija te hranu koja je najskuplja


    public static Item[] removeItem(Item[] items, int choice) {
        if (items == null || choice < 0 || choice >= items.length) {
            return items;
        }


        Item[] itemsCopy = new Item[items.length - 1];

        for (int i = 0, k = 0; i < items.length; i++) {
            if (i == choice) {
                continue;
            }
            itemsCopy[k++] = items[i];
        }

        return itemsCopy;
    }


    private static Item[] addItem(Item[] arr, Item item) {
        Item[] tmp = new Item[arr.length + 1];
        tmp[arr.length] = item;
        return tmp;
    }


    private static Category[] setCategories() {
        Category[] categories = new Category[NUM_CATEGORIES];
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            System.out.println("Upisite ime " + (i + 1) + ". kategorije.");
            String name = scanner.nextLine();
            System.out.println("Unesite opis " + (i + 1) + ". kategorije");
            String description = scanner.nextLine();
            categories[i] = new Category(name, description);
        }
        return categories;
    }

    private static Item[] setItems(Category[] categories) {
        Item[] items = new Item[NUM_ITEMS];
        // dodati da se trazi da li korisnik zeli namjernicu i onda odabere koju to i popuni ju podacima

        //sout zelite li odabrati artikl hrane ili ostale artikle?
        // banan ili krompir
        // Item.price je cijena po KG od banane il krompira
        // Nakon odabira namirnice je potrebno izračunati broj kilokalorija namirnice te ih
        //ispisati na ekran te cijenu s obzirom na težinu (vrijednost u varijabli „price“ u klasi „Item“
        //uzimati kao cijenu za jedan kilogram namirnice). Također je potrebno preračunati cijenu
        //namirnice na način da se uzima u obzir težina po kilogramu te cijena po kilogramu.
        for (int i = 0; i < NUM_ITEMS; i++) {
            if (selectFood()) {
                System.out.println("Zelite li unesti KG |1|banane ili |2|krumpira?");
                int izbor = scanInt(1, 2);
                System.out.print("Molimo upisite kolicinu hrane u KG sa decimalom:");
                BigDecimal kilaHrane = scanBigDecimal();
                if (izbor == 1) {
                    System.out.println("Unesite cijenu banane po kili sa decoimalom:");
                    BigDecimal cijenaBanane = scanBigDecimal();
                    System.out.println("Cijena banane je :" + (cijenaBanane.divide(kilaHrane)));
                    items[i] = new Item.Builder("Banana")
                            .sellingPrice(cijenaBanane)
                            .height(new BigDecimal(2))
                            .length(new BigDecimal(15))
                            .width(new BigDecimal(3))
                            .build();
                } else {


                }
            } else {
                System.out.println("Unesite ime " + (i + 1) + ". artikla:");
                String name = scanner.nextLine();
                System.out.println("Izaberite kategoriju " + (i + 1) + ". artikla:");
                for (int j = 0; j < NUM_CATEGORIES; j++) {
                    System.out.println("|" + (j + 1) + "| " + categories[j].getName());
                }
                Integer izbor;
                izbor = scanInt(0, categories.length);


                System.out.println("Unesite sirinu " + (i + 1) + ". artikla:");
                BigDecimal sirina = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.println("Unesite visinu " + (i + 1) + ". artikla:");
                BigDecimal visina = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.println("Unesite duzinu " + (i + 1) + ". artikla:");
                BigDecimal duzina = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.println("Unesite cijenu izrade " + (i + 1) + ". artikla:");
                BigDecimal cijenaIzrade = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.println("Unesite prodajnu cijenu " + (i + 1) + ". artikla:");
                BigDecimal prodajnaCijena = scanner.nextBigDecimal();
                scanner.nextLine();


                items[i] = new Item.Builder(name)
                        .category(categories[izbor])
                        .width(sirina)
                        .height(visina)
                        .length(duzina)
                        .productionCost(cijenaIzrade)
                        .sellingPrice(prodajnaCijena)
                        .build();
            }
        }
        return items;
    }

    private static Factory[] setFactories(Item[] items) {
        Factory[] factories = new Factory[NUM_FACTORIES];
        Item[] itemsCopy = Arrays.copyOf(items, items.length);

        for (int i = 0; i < NUM_FACTORIES; i++) {
            System.out.println("Unesite ime " + (i + 1) + ". tvornice:");
            String name = scanner.nextLine();
            //finalItems = getItems(itemsCopy);
            System.out.println("Napisite ime ulice u kojoj se nalazi tvornica:");
            String ulica = scanner.nextLine();
            System.out.println("Napisite kucni broj u kojoj se nalazi tvornica:");
            String kucniBroj = scanner.nextLine();
            System.out.println("Napisite grad u kojoj se nalazi tvornica:");
            String grad = scanner.nextLine();
            System.out.println("Napisite postanski broj u kojoj se nalazi tvornica:");
            String postanskiBroj = scanner.nextLine();
            Address address = new Address(ulica, kucniBroj, grad, postanskiBroj);


            Item[] finalItems = new Item[0];
            boolean end = false;
            while (end != true) {
                System.out.println("Izaberite artikle:");
                for (int j = 0; j < itemsCopy.length; j++) {
                    System.out.println("|" + (j) + "| " + items[j].getName());
                }
                System.out.println("|" + itemsCopy.length + "| Zavrsetak izbora");


                int choice = scanInt(0, itemsCopy.length);
                if (choice == itemsCopy.length) {
                    end = true;
                } else {
                    finalItems = addItem(itemsCopy, itemsCopy[choice]);
                    itemsCopy = removeItem(itemsCopy, choice);
                }
            }
            factories[i] = new Factory(name, finalItems, address);

        }
        return factories;
    }

    private static Store[] setStores(Item[] items) {
        Store[] stores = new Store[NUM_STORES];
        Item[] itemsCopy = Arrays.copyOf(items, items.length);
        for (int i = 0; i < NUM_STORES; i++) {
            System.out.println("Unesite ime " + (i + 1) + ". ducana:");
            String name = scanner.nextLine();
            System.out.println("Unesite web adresu ducana:");
            String webAdresa = scanner.nextLine();

            Item[] finalItems = new Item[0];
            boolean end = false;
            while (end != true) {
                System.out.println("Izaberite artikle:");
                for (int j = 0; j < itemsCopy.length; j++) {
                    System.out.println("|" + (j) + "| " + items[j].getName());
                }
                System.out.println("|" + itemsCopy.length + "| Zavrsetak izbora");


                int choice = scanInt(0, itemsCopy.length);
                if (choice == itemsCopy.length) {
                    end = true;
                } else {
                    finalItems = addItem(itemsCopy, itemsCopy[choice]);
                    itemsCopy = removeItem(itemsCopy, choice);


                }

            }

            stores[i] = new Store(name, webAdresa, finalItems);
        }
        return stores;
    }


    public static void main(String[] args) {
        Category[] categories = setCategories();
        Item[] items = setItems(categories);

        //Factory[] factories = setFactories(items);
        //Store[] stores = setStores(items);
        //System.out.println("Factory with biggest volume is:"+biggestVolume(factories));
        //System.out.println("Store with cheapest item is"+cheapestStore(stores));

    }
}
