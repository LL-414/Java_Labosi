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


    private static Item[] addItem(Item[] arr, Item item) {
        Item[] tmp = new Item[arr.length + 1];
        tmp[arr.length] = item;
        return tmp;
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
                scanner.nextLine();
            }
        }
        return inputBigDecimal;
    }

    public static BigDecimal scanBigDecimal(BigDecimal minBigDecimal, BigDecimal maxBigDecimal) {
        BigDecimal inputBigDecimal;
        while (true) {

            if (scanner.hasNextInt()) {
                inputBigDecimal = scanner.nextBigDecimal();
                scanner.nextLine();
                if (inputBigDecimal.compareTo(minBigDecimal) >= 0 && inputBigDecimal.compareTo(maxBigDecimal) <= 0) {
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
        return inputBigDecimal;
    }

    //____________________________________________________________________________________________________________


    public static String findMostCaloricFood(Item[] items) {
        int maxCalories = 0;
        Item mostCaloricFood = null;

        for (Item item : items) {
            if (item instanceof Edible) {
            if( ((Edible) item).calculateKilocalories()>maxCalories){
                mostCaloricFood = item;
                maxCalories = ((Edible) item).calculateKilocalories();
            }
            }
        }
        if(mostCaloricFood == null){
            return "Nema laptopa";
        }else{
            return mostCaloricFood.getName()+" mjeseci garancije:"+ maxCalories;
        }
    }
    public static String findLaptopWithLeasWarranty(Item[] items) {
        int biggestWarranty = 0;
        Item laptopWithBestWarranty = null;

        for (Item item : items) {
            if (item instanceof Technical) {
                if( ((Technical) item).warranty()>biggestWarranty){
                    laptopWithBestWarranty = item;
                    biggestWarranty = ((Technical) item).warranty();
                }
            }
        }
       if(laptopWithBestWarranty == null){
        return "Nema laptopa";
       }else{
           return laptopWithBestWarranty.getName()+" mjeseci garancije:"+ biggestWarranty;
       }
    }
    public static Item findLaptopWithSmallestWarranty(Item[] items){

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


    //____________________________________________________________________________________________________________

    public static Item setArticles(int i,Category[] categories,int izbor){
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
                    .build();
        }else {
            return new Item.Builder(name)
                    .category(categories[izbor])
                    .width(sirina)
                    .height(visina)
                    .length(duzina)
                    .productionCost(cijenaIzrade)
                    .sellingPrice(prodajnaCijena)
                    .build();
        }
    }
    public static Krumpir setKrumpir(BigDecimal kilaHrane){
        System.out.println("Unesite vrstu krumpira:");
        String vrstaKrumpira = scanner.nextLine();
        System.out.println("Unesite cijenu krumpira po kili sa decoimalom:");
        BigDecimal cijenaKrumpira = scanBigDecimal();
        System.out.println("Cijena Krumpira je :" + (cijenaKrumpira.multiply(kilaHrane)));
        return  new Krumpir(new Item.Builder(vrstaKrumpira)
                .sellingPrice(cijenaKrumpira)
                ,kilaHrane);
    }
    public static Banana setBanana(BigDecimal kilaHrane){
        System.out.println("Unesite vrstu banane:");
        String vrstaBanane = scanner.nextLine();
        System.out.println("Unesite cijenu banane po kili sa decoimalom:");
        BigDecimal cijenaBanane = scanBigDecimal();
        System.out.println("Cijena banane je :" + (cijenaBanane.multiply(kilaHrane)));
        return new Banana(new Item.Builder(vrstaBanane)
                .sellingPrice(cijenaBanane)
                ,kilaHrane);
    }
    public static Laptop setLaptop(){
        System.out.print("Molimo unesite garanciju za laptop u trajanju mjeseca:");
        int garancija = scanInt(1,60);
        System.out.println("Unesite ime laptopa:");
        String name = scanner.nextLine();
        return new Laptop.LaptopBuilder()
                .setBuilder(new Item.Builder(name).sellingPrice(BigDecimal.valueOf(600)))
                .setWarrantyMonths(garancija)
                .build();
    }


    private static Category[] setCategories() {
        Category[] categories = new Category[NUM_CATEGORIES+2];
        categories[0] = new Category("Food","Is edible");
        categories[1] = new Category("Laptop","Various laptops");
        for (int i = 2; i < NUM_CATEGORIES+2; i++) {
            System.out.println("Upisite ime " + (i - 1) + ". kategorije.");
            String name = scanner.nextLine();
            System.out.println("Unesite opis " + (i - 1) + ". kategorije");
            String description = scanner.nextLine();
            categories[i] = new Category(name, description);
        }
        return categories;
    }

    private static Item[] setItems(Category[] categories) {
        Item[] items = new Item[NUM_ITEMS];
        for (int i = 0; i < NUM_ITEMS; i++) {
        System.out.println("Izaberite kategoriju " + (i + 1) + ". artikla:");
        for (int j = 0; j < NUM_CATEGORIES+2; j++) {
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
                   items[i] = setBanana(kilaHrane);
                } else {
                    items[i] = setKrumpir(kilaHrane);

                }
            }else if(izbor==2){
                items[i] = setLaptop();
            } else {
                items[i] = setArticles(i,categories,izbor);
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
            System.out.println("Napisite ime ulice u kojoj se nalazi tvornica:");
            String ulica = scanner.nextLine();
            System.out.println("Napisite kucni broj u kojoj se nalazi tvornica:");
            String kucniBroj = scanner.nextLine();
            System.out.println("Napisite grad u kojoj se nalazi tvornica:");
            String grad = scanner.nextLine();
            System.out.println("Napisite postanski broj u kojoj se nalazi tvornica:");
            String postanskiBroj = scanner.nextLine();
           Address address = new Address.AddressBuilder()
                   .setPostalCode(postanskiBroj)
                   .setCity(grad)
                   .setStreet(ulica)
                   .setHouseNumber(kucniBroj)
                   .createAddress();


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
        findMostCaloricFood(items);
        //Factory[] factories = setFactories(items);
        //Store[] stores = setStores(items);
        //System.out.println("Factory with biggest volume is:"+biggestVolume(factories));
        //System.out.println("Store with cheapest item is"+cheapestStore(stores));

    }
}
