package hr.java.production.model;

import hr.java.production.main.NamedEntity;

public class Category extends NamedEntity {
    private String name, description;

    public Category(String name, String description) {
        super(name);
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}