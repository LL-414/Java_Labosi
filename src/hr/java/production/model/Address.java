package hr.java.production.model;


import hr.java.production.enumerator.Gradovi;

import java.io.Serializable;

public class Address implements Serializable {
    private String street, houseNumber;
    Gradovi gradovi;
    Long id;
public static class AddressBuilder {
    Gradovi gradovi;
    private String street;
    private String houseNumber;
    private Long id;

    public AddressBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressBuilder setGradovi(Gradovi gradovi){
        this.gradovi = gradovi;
        return this;
    }
    public AddressBuilder setIndex(Long id){
        this.id = id;
        return this;
    }

    public Address createAddress() {
        Address address = new Address();
        address.houseNumber = this.houseNumber;
        address.street = this.street;
        address.gradovi = this.gradovi;
        address.id  = this.id;
        return address;
    }
}

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Gradovi getGradovi() {
        return gradovi;
    }

    public Long getId() {
        return id;
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
