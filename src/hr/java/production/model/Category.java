package hr.java.production.model;

import hr.java.production.main.NamedEntity;

public class Category extends NamedEntity {
    private String  description;

    public Category(String name,Long id, String description) {
        super(name,id);
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}