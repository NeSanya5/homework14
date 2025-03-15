package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    int FixPrice = 2000;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FixPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " Фиксированная цена " + FixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
