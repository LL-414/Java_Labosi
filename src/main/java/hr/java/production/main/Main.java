package hr.java.production.main;


import model.Category;
import model.Factory;
import model.Item;
import model.Store;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private static final Integer NUM_CATEGORIES = 3;
    private static final Integer NUM_ITEMS = 5;
    private static final Integer NUM_FACTORIES = 2;
    private static final Integer NUM_STORES = 2;
    public Category[] categories;
    public Item item1, item2, item3, item4, item5;
    public Factory factory1, factory2;
    public Store store1, store2;


    public void setCategories() {
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            System.out.println("Upisite ime " + (i + 1) + ". kategorije.");
            String name = scanner.nextLine();
            String description = scanner.nextLine();
            categories[i] = new Category(name, description);
        }

    }

    public static void main(String[] args) {

    }
}
