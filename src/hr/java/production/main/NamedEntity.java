package hr.java.production.main;

import java.io.Serializable;

public abstract class NamedEntity implements Serializable {
    protected String name;
    protected Long id;

    public NamedEntity(String name, Long id) {
        this.name = name;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
