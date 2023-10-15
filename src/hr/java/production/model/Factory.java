package hr.java.production.model;

import java.util.Arrays;

public class Factory {
    private String name;
    private Item[] items;
    private Address address;

    public Factory(String name, Item[] items, Address address) {
        this.name = name;
        this.items = items;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                ", items=" + Arrays.toString(items) +
                ", address=" + address +
                '}';
    }
}
