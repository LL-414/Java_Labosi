package hr.java.production.model;

import hr.java.production.main.Edible;

import java.math.BigDecimal;

public class Banana extends Item implements Edible {

    private static final int caloriesPerKG = 105;
    private BigDecimal weightKG;

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public int calculateKilocalories(BigDecimal weightKG) {
        BigDecimal totalCalories = weightKG.multiply(new BigDecimal(caloriesPerKG));
        return totalCalories.intValue();
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return null;
    }

    public Banana(Item.Builder builder, BigDecimal weight) {
        super(builder);
        this.weightKG = weight;
    }

    public BigDecimal getWeight() {
        return weightKG;
    }

    public void setWeight(BigDecimal weight) {
        this.weightKG = weight;
    }

}
