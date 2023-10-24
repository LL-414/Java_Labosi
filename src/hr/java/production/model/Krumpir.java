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
    protected Krumpir(Item.Builder builder) {
        super(builder);
    }

    public static class KrumpirBuilder {
        private Item.Builder builder;
        private BigDecimal weightKG;

        public KrumpirBuilder setBuilder(Item.Builder builder) {
            this.builder = builder;
            return this;
        }

        public KrumpirBuilder setWeightKG(BigDecimal weightKG) {
            this.weightKG = weightKG;
            return this;
        }

        public Krumpir createKrumpir() {
            return new Krumpir(builder);
        }
    }

    public BigDecimal getWeightKG() {
        return weightKG;
    }


}
