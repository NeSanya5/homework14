package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : ";
    }

    public abstract boolean isSpecial();

}
