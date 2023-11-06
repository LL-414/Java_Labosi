package hr.java.production.model;


import hr.java.production.enumerator.Gradovi;

public class Address  {
    private String street, houseNumber;
    Gradovi gradovi;
public static class AddressBuilder {
    Gradovi gradovi;
    private String street;
    private String houseNumber;

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

    public Address createAddress() {
        Address address = new Address();
        address.houseNumber = this.houseNumber;
        address.street = this.street;
        address.gradovi = this.gradovi;
        return address;
    }
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
