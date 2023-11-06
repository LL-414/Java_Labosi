package hr.java.production.model;

public final class Laptop extends Item implements Technical {

    private int warrantyMonths;

    public Laptop(Builder builder, int warrantyMonths) {
        super(builder);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public int warranty() {
        return warrantyMonths;
    }
    public static class LaptopBuilder {
        private Item.Builder builder;
        private int warrantyMonths;

        public LaptopBuilder setBuilder(Item.Builder builder) {
            this.builder = builder;
            return this;
        }

        public LaptopBuilder setWarrantyMonths(int warrantyMonths) {
            this.warrantyMonths = warrantyMonths;
            return this;
        }

        public Laptop build() {
            return new Laptop(builder, warrantyMonths);
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
