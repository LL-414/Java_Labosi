package hr.java.production.interfaces;

import java.math.BigDecimal;

public interface Edible {
    public boolean isEdible();

    int calculateKilocalories();

    public BigDecimal calculatePrice(BigDecimal weight);
}
