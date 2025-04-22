package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Objects;


public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Неправильное имя для продукта ");
        } else {
            this.nameProduct = name;
        }
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(nameProduct, ((Product) o).nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}
