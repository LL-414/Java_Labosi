package hr.java.production.main;

import hr.java.production.enumerator.Gradovi;
import hr.java.production.exception.Duplicate_Item;
import hr.java.production.model.*;


import java.awt.*;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.*;
import java.util.List;


public class Main {

    private static final Integer NUM_CATEGORIES = 3;
    private static final Integer NUM_ITEMS = 5;
    private static final Integer NUM_FACTORIES = 2;
    private static final Integer NUM_STORES = 2;
    static Scanner scanner = new Scanner(System.in);

    //____________________________________________________________________________________________________________
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


    private static Item[] addItem(List<Item> arr, Item item) {
        Item[] tmp = new Item[arr.size() + 1];
        tmp[arr.size()] = item;
        return tmp;
    }


    public static int scanInt(int min, int max) {
        Integer choice;
        while (true) {

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Krivi unos. Unesite broj između " + min + " i " + max + ".");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Krivi unos molimo ponovite!");
                scanner.nextLine();
            }
        }
        return choice;
    }


    public static BigDecimal scanBigDecimal() {
        BigDecimal inputBigDecimal;
        while (true) {
            try {
                inputBigDecimal = scanner.nextBigDecimal();
                scanner.nextLine();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Krivi unos molimo ponovite!");
                scanner.nextLine();
            }
        }
        return inputBigDecimal;
    }

    public static BigDecimal scanBigDecimal(BigDecimal minBigDecimal, BigDecimal maxBigDecimal) {
        BigDecimal inputBigDecimal;
        while (true) {
            try {
                inputBigDecimal = scanner.nextBigDecimal();
                scanner.nextLine();
                if (inputBigDecimal.compareTo(minBigDecimal) >= 0 && inputBigDecimal.compareTo(maxBigDecimal) <= 0) {
                    break;
                } else {
                    System.out.println("Krivi unos. Unesite broj između " + minBigDecimal + " i " + maxBigDecimal + ".");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Krivi unos molimo ponovite!");
                scanner.nextLine();
            }
        }
        return inputBigDecimal;
    }

    //____________________________________________________________________________________________________________


    public static String findMostCaloricFood(Item[] items) {
        int maxCalories = 0;
        Item mostCaloricFood = null;

        for (Item item : items) {
            if (item instanceof Edible) {
                if (((Edible) item).calculateKilocalories() > maxCalories) {
                    mostCaloricFood = item;
                    maxCalories = ((Edible) item).calculateKilocalories();
                }
            }
        }
        if (mostCaloricFood == null) {
            return "Nema laptopa";
        } else {
            return mostCaloricFood.getName() + " mjeseci garancije:" + maxCalories;
        }
    }

    public static String findLaptopWithLeasWarranty(Item[] items) {
        int biggestWarranty = 0;
        Item laptopWithBestWarranty = null;

        for (Item item : items) {
            if (item instanceof Technical) {
                if (((Technical) item).warranty() > biggestWarranty) {
                    laptopWithBestWarranty = item;
                    biggestWarranty = ((Technical) item).warranty();
                }
            }
        }
        if (laptopWithBestWarranty == null) {
            return "Nema laptopa";
        } else {
            return laptopWithBestWarranty.getName() + " mjeseci garancije:" + biggestWarranty;
        }
    }

    public static Item findLaptopWithSmallestWarranty(Item[] items) {

        Item laptop = null;

        for (Item item : items) {
            if (item instanceof Laptop) {

            }
        }

        return laptop;
    }

    private static String biggestVolume(Factory[] factories) {
        String biggestFactory = null;
        BigDecimal biggestVolume = BigDecimal.ZERO;

        for (int i = 0; i < factories.length; i++) {
            BigDecimal factoryVolume = BigDecimal.ZERO;

            for (int j = 0; j < factories[i].getItems().size(); j++) {
                Item tmpItem = factories[i].getItems().iterator().next();
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


    //____________________________________________________________________________________________________________

    public static Item setArticles(int i, Category[] categories, int izbor) {
        System.out.println("Unesite ime " + (i) + ". artikla:");
        String name = scanner.nextLine();
        System.out.println("Unesite sirinu " + (i) + ". artikla:");
        BigDecimal sirina = scanBigDecimal();
        System.out.println("Unesite visinu " + (i) + ". artikla:");
        BigDecimal visina = scanBigDecimal();
        System.out.println("Unesite duzinu " + (i) + ". artikla:");
        BigDecimal duzina = scanBigDecimal();
        System.out.println("Unesite cijenu izrade " + (i) + ". artikla:");
        BigDecimal cijenaIzrade = scanBigDecimal();
        System.out.println("Unesite prodajnu cijenu " + (i) + ". artikla:");
        BigDecimal prodajnaCijena = scanBigDecimal();
        System.out.println("Unesite popust pri prodaji ako nema popusta unesite 0:");
        BigDecimal discount = scanBigDecimal(BigDecimal.valueOf(0), BigDecimal.valueOf(100));

        if (discount.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal discountedPrice = prodajnaCijena.multiply(BigDecimal.ONE.subtract(discount.divide(BigDecimal.valueOf(100))));
            return new Item.Builder(name)
                    .category(categories[izbor])
                    .width(sirina)
                    .height(visina)
                    .length(duzina)
                    .productionCost(cijenaIzrade)
                    .sellingPrice(discountedPrice)
                    .index(i)
                    .build();
        } else {
            return new Item.Builder(name)
                    .category(categories[izbor - 1])
                    .width(sirina)
                    .height(visina)
                    .length(duzina)
                    .productionCost(cijenaIzrade)
                    .sellingPrice(prodajnaCijena)
                    .index(i)
                    .build();
        }
    }

    public static Krumpir setKrumpir(BigDecimal kilaHrane, int i) {
        System.out.println("Unesite vrstu krumpira:");
        String vrstaKrumpira = scanner.nextLine();
        System.out.println("Unesite cijenu krumpira po kili sa decoimalom:");
        BigDecimal cijenaKrumpira = scanBigDecimal();
        System.out.println("Cijena Krumpira je :" + (cijenaKrumpira.multiply(kilaHrane)));
        return new Krumpir(new Item.Builder(vrstaKrumpira)
                .sellingPrice(cijenaKrumpira)
                .index(i)
                , kilaHrane);
    }

    public static Banana setBanana(BigDecimal kilaHrane, int i) {
        System.out.println("Unesite vrstu banane:");
        String vrstaBanane = scanner.nextLine();
        System.out.println("Unesite cijenu banane po kili sa decoimalom:");
        BigDecimal cijenaBanane = scanBigDecimal();
        System.out.println("Cijena banane je :" + (cijenaBanane.multiply(kilaHrane)));
        return new Banana(new Item.Builder(vrstaBanane)
                .sellingPrice(cijenaBanane)
                .index(i)
                , kilaHrane);
    }

    public static Laptop setLaptop(int i) {
        System.out.print("Molimo unesite garanciju za laptop u trajanju mjeseca:");
        int garancija = scanInt(1, 60);
        System.out.println("Unesite ime laptopa:");
        String name = scanner.nextLine();
        return new Laptop.LaptopBuilder()
                .setBuilder(new Item.Builder(name).sellingPrice(BigDecimal.valueOf(600)).index(i))
                .setWarrantyMonths(garancija)
                .build();
    }


    private static Category[] setCategories() {
        Category[] categories = new Category[NUM_CATEGORIES + 2];
        categories[0] = new Category("Food", "Is edible");
        categories[1] = new Category("Laptop", "Various laptops");
        for (int i = 2; i < NUM_CATEGORIES + 2; i++) {
            System.out.println("Upisite ime " + (i - 1) + ". kategorije.");
            String name = scanner.nextLine();
            System.out.println("Unesite opis " + (i - 1) + ". kategorije");
            String description = scanner.nextLine();
            categories[i] = new Category(name, description);
        }
        return categories;
    }

    private static List<Item> setItems(Category[] categories) {
        Item[] items = new Item[NUM_ITEMS];
        List<Item> itemList = new ArrayList<>(NUM_ITEMS);
        for (int i = 0; i < NUM_ITEMS; i++) {
            System.out.println("Izaberite kategoriju " + (i + 1) + ". artikla:");
            for (int j = 0; j < NUM_CATEGORIES + 2; j++) {
                System.out.println("|" + (j + 1) + "| " + categories[j].getName());
            }
            Integer izbor;
            izbor = scanInt(0, categories.length);
            if (izbor == 1) {
                System.out.println("Zelite li unesti KG |1|banane ili |2|krumpira?");
                int izborHrane = scanInt(1, 2);
                System.out.print("Molimo upisite kolicinu hrane u KG sa decimalom:");
                BigDecimal kilaHrane = scanBigDecimal();
                if (izborHrane == 1) {
                    items[i] = setBanana(kilaHrane, i);
                    itemList.add(setBanana(kilaHrane, i));
                } else {
                    items[i] = setKrumpir(kilaHrane, i);
                    itemList.add(setKrumpir(kilaHrane, i));
                }
            } else if (izbor == 2) {
                items[i] = setLaptop(i);
                itemList.add(setLaptop(i));
            } else {
                items[i] = setArticles(i, categories, izbor);
                itemList.add(setArticles(i, categories, izbor));
            }
        }

        return itemList;
    }
//_________________________________________________________________________________


    private static Factory[] setFactories(List<Item> items) {
        Factory[] factories = new Factory[NUM_FACTORIES];
        Integer[] index = new Integer[NUM_ITEMS];
        Integer itemCoutner = 0;
        //Item[] itemsCopy = Arrays.copyOf(items, items.length);
        for (int i = 0; i < NUM_FACTORIES; i++) {
            Item[] finalItems = new Item[0];
            Set<Item> finalItemSet = new HashSet<>();
            System.out.println("Unesite ime " + (i + 1) + ". tvornice:");
            String name = scanner.nextLine();
            System.out.println("Napisite ime ulice u kojoj se nalazi tvornica:");
            String ulica = scanner.nextLine();
            System.out.println("Napisite kucni broj u kojoj se nalazi tvornica:");
            String kucniBroj = scanner.nextLine();
            System.out.println("Napisite grad u kojoj se nalazi tvornica");
            System.out.println("1 Ivanic|2 Zagreb|3 Sesvete");
            int grad = scanInt(1, 3);
            Gradovi gradovi= Gradovi.IVANIC_GRAD;
            switch (grad) {
                case (1):
                    break;
                case (2):
                    gradovi = Gradovi.ZAGREB;
                    break;
                case (3):
                    gradovi = Gradovi.SESVETE;
                    break;
            }
            System.out.println("Napisite postanski broj u kojoj se nalazi tvornica:");
            String postanskiBroj = scanner.nextLine();
            Address address = new Address.AddressBuilder()
                    .setGradovi(gradovi)
                    .setStreet(ulica)
                    .setHouseNumber(kucniBroj)
                    .createAddress();


            while (true) {
                try {
                    System.out.println("Izaberite artikle:");
                    for (int j = 0; j < (int) items.size(); j++) {
                        System.out.println("|" + (j) + "| " + items.get(i).getName());
                    }
                    System.out.println("|" + items.size() + "| Zavrsetak izbora");
                    int choice = scanInt(0, items.size());


                    if (i != 0) {
                        if (choice == items.size()) {
                            break;
                        } else {
                            for (int h = 0; h == itemCoutner; h++) {
                                if (choice == index[h]) {
                                    throw new Duplicate_Item("Artiikl vec postoji");
                                }
                            }
                            //finalItems = addItem(items, items.get(choice));
                            finalItemSet.add(items.get(choice));
                            index[itemCoutner] = items.get(choice).getIndex();
                            itemCoutner++;
                        }
                    } else {
                        finalItems = addItem(items, items.get(choice));
                        finalItemSet.add(items.get(choice));
                        index[itemCoutner] = items.get(choice).getIndex();
                        itemCoutner++;
                    }
                } catch (Duplicate_Item ex) {
                    System.out.println(ex.getMessage());
                }


            }


            factories[i] = new Factory(name, finalItemSet, address);

        }
        return factories;
    }



  /*  private static Store[] setStores(Item[] items) {
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
    }*/


    public static void main(String[] args) {
        Category[] categories = setCategories();
        List<Item> itemList = setItems(categories);
        Map<Category,List<Item>> mapCategories = setMapCategories();
        //findMostCaloricFood(items);
        Factory[] factories = setFactories(itemList);
        //Store[] stores = setStores(items);
        //System.out.println("Factory with biggest volume is:"+biggestVolume(factories));
        //System.out.println("Store with cheapest item is"+cheapestStore(stores));

    }

    private static Map<Category, List<Item>> setMapCategories() {
    return null;
    }
}
