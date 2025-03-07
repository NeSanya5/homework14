package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int prise;
    private int discount;

    public DiscountedProduct(String name, int prise, int discount) {
        super(name);
        this.prise = prise;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return prise - ((prise/100)*discount);
    }

    @Override
    public String toString() {
        return super.toString() + getPrice() + " (Скидка " + discount + "%)";
    }

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
