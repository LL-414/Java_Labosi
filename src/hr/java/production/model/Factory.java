package hr.java.production.model;

import hr.java.production.main.NamedEntity;

import java.util.Arrays;
import java.util.Set;

public class Factory extends NamedEntity {
   // private String name;

    private Set<Item> items;
    private Address address;

    public Factory(String name,Long id, Set<Item> items, Address address) {
        super(name,id);
        this.items = items;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items ) {
        this.items = items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
