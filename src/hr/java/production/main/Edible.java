package hr.java.production.main;

import java.math.BigDecimal;

public interface Edible {
    public boolean isEdible();

    int calculateKilocalories(BigDecimal weightKG);

    public BigDecimal calculatePrice(BigDecimal weight);
}
