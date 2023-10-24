package hr.java.production.model;

import hr.java.production.main.NamedEntity;

import java.util.Arrays;

public class Factory extends NamedEntity {
    private String name;
    private Item[] items;
    private Address address;

    public Factory() {
        super(null);
    }

    public static class FactoryBuilder {
        private String name;
        private Item[] items;
        private Address address;

        public FactoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public FactoryBuilder setItems(Item[] items) {
            this.items = items;
            return this;
        }

        public FactoryBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Factory createFactory() {
            Factory factory = new Factory();
            this.address = factory.address;
            this.name = factory.name;
            this.items = factory.items;
            return factory;

        }
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


}
