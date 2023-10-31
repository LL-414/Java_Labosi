package hr.java.production.model;

import hr.java.production.main.NamedEntity;

import java.math.BigDecimal;

public class Item extends NamedEntity {
    protected Integer index;
    protected String color;
    protected Category category;
    protected BigDecimal width, height, length, productionCost, sellingPrice;
    protected Discount discount;


    protected Item(Builder builder) {
        super(builder.name);
        this.category = builder.category;
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.productionCost = builder.productionCost;
        this.sellingPrice = builder.sellingPrice;
        this.discount = builder.discount;
        this.index = builder.index;
        this.color = builder.color;
    }

    public static class Builder {
        private String color;
        private String name;
        private Integer index;
        private Category category;
        private BigDecimal width, height, length, productionCost, sellingPrice;
        private Discount discount;


        public Builder(String name) {
            this.name = name;
        }

        public Builder index(Integer index) {
            this.index = index;
            return this;
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
        public Builder color(String color){
            this.color= color;
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

    public String getColor() {
        return color;
    }

    public Integer getIndex() {
        return index;
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
}