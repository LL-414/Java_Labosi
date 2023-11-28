package hr.java.production.interfaces;

public sealed interface Technical permits Laptop {
    public int warranty();
}
