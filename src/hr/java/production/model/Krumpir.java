package hr.java.production.model;

import hr.java.production.main.Edible;

import java.math.BigDecimal;

public class Krumpir extends Item implements Edible {
    private static final int caloriesPerKG = 200;
    private BigDecimal weightKG;

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public int calculateKilocalories() {
        BigDecimal totalCalories = weightKG.multiply(new BigDecimal(caloriesPerKG));
        return totalCalories.intValue();
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return null;
    }

    public Krumpir(Builder builder, BigDecimal weightKG) {
        super(builder);
        this.weightKG = weightKG;
    }

    public BigDecimal getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(BigDecimal weightKG) {
        this.weightKG = weightKG;
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
