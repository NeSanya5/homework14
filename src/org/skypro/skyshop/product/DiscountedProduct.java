package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int prise;
    private int discount;

    public DiscountedProduct(String name, int prise, int discount) {
        super(name);
        if (prise <= 1) {
            throw new IllegalArgumentException("цена не может быть мень 0");
        } else {
            this.prise = prise;
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("скидка указана неправильно");
        }
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
        return getNameProduct();
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}
