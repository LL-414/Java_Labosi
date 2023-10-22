package hr.java.production.model;

public sealed interface Technical permits Laptop{
    public int warranty();
}
