package hr.java.production.sort;

import hr.java.production.model.Item;

import java.util.Comparator;
import java.util.List;

public class ProductionSorter implements Comparator<Item> {


    @Override
    public int compare(Item o1, Item o2) {
        if(o1.getSellingPrice().compareTo(o2.getSellingPrice()) == 0){
            return 0;
        } else if (o1.getSellingPrice().compareTo(o2.getSellingPrice()) == -1) {
            return -1;
        }else {
            return 1;
        }
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }
}
