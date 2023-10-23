package hr.java.production.model;


public class Address {
    private String street, houseNumber, city, postalCode;
public static class AddressBuilder {
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;

    public AddressBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Address createAddress() {
        Address address = new Address();
        address.city = this.city;
        address.houseNumber = this.houseNumber;
        address.postalCode = this.postalCode;
        address.street = this.street;
        return address;
    }
}
}
