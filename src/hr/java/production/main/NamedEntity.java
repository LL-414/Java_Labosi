package hr.java.production.main;

public abstract class NamedEntity {
    protected String name;

    public NamedEntity(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
