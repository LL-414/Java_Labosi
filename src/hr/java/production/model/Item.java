package hr.java.production.model;

import hr.java.production.main.NamedEntity;

import java.math.BigDecimal;

public class Item extends NamedEntity {
    protected Category category;
    protected BigDecimal width, height, length, productionCost, sellingPrice;
    protected Discount discount;


    protected Item(Builder builder) {
        super(builder.name,builder.id);
        this.category = builder.category;
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.productionCost = builder.productionCost;
        this.sellingPrice = builder.sellingPrice;
    }

    public static class Builder {
        private String name;
        private Long id;

        private Category category;
        private BigDecimal width, height, length, productionCost, sellingPrice;
        private Discount discount;


        public Builder(String name,Long id) {
            this.name = name;
            this.id = id;
        }




        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder width(BigDecimal width) {
            this.width = width;
            return this;
        }

        public Builder height(BigDecimal height) {
            this.height = height;
            return this;
        }

        public Builder length(BigDecimal length) {
            this.length = length;
            return this;
        }

        public Builder productionCost(BigDecimal productionCost) {
            this.productionCost = productionCost;
            return this;
        }

        public Builder sellingPrice(BigDecimal sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }

        public Builder discount(Discount discount) {
            this.discount = discount;
            return this;
        }


        public Item build() {
            return new Item(this);
        }
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getLength() {
        return length;
    }


    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }



    public Discount getDiscount() {
        return discount;
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