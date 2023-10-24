package hr.java.production.model;

import hr.java.production.main.NamedEntity;

public class Category extends NamedEntity {
    private String  description;


    protected Category(CategoryBuilder builder){
        super(builder.name);
        this.description = builder.description;
    }
    public static class CategoryBuilder{
        private String name;
        private String description;
        public CategoryBuilder(String name){
            this.name = name;
        }
        public CategoryBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Category build() {
            return new Category(this);
        }

    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}