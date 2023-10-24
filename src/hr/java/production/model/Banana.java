package hr.java.production.model;

import hr.java.production.main.Edible;

import java.math.BigDecimal;

public class Banana extends Item implements Edible {

    private static final int caloriesPerKG = 105;
    private BigDecimal weightKG;

    protected Banana(Item.Builder builder) {
        super(builder);
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public int calculateKilocalories() {
        BigDecimal totalCalories = weightKG.multiply(new BigDecimal(caloriesPerKG));
        return totalCalories.intValue();
    }
    public static class BananaBuilder {
        private Item.Builder builder;
        private BigDecimal weightKG;

        public BananaBuilder setBuilder(Item.Builder builder) {
            this.builder = builder;
            return this;
        }

        public BananaBuilder setWeightKG(BigDecimal weightKG) {
            this.weightKG = weightKG;
            return this;
        }

        public Banana createBanana() {
            return new Banana(builder);
        }
    }

    public BigDecimal getWeight() {
        return weightKG;
    }



}
