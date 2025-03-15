package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;


public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String name) {
        this.nameProduct = name;
    }

    public abstract int getPrice();

    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return nameProduct + " : ";
    }

    public abstract boolean isSpecial();

}
