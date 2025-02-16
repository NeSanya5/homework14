package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    @Override
    public String toString() {
        return name + " : " + price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
}
