package hr.java.production.sort;

import hr.java.production.model.Item;

import java.util.Comparator;
import java.util.List;

public class ProductionSorter implements Comparator<Item> {


    @Override
    public int compare(Item o1, Item o2) {
       return o1.getSellingPrice().compareTo(o2.getSellingPrice());
    }


    public int compareWarrantes(Item o1, Item o2) {
        return o1.getWarranty().compareTo(o2.getWarranty());
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }
}
