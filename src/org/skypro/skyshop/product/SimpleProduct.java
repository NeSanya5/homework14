package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int prise;

    public SimpleProduct(String name, int prise) {
        super(name);
        if (prise <= 1) {
            throw new IllegalArgumentException("цена не может быть меньше 0");
        } else {
            this.prise = prise;
        }
    }
    public int getPrice(){
        return prise;
    }
    public String toString() {
        return super.toString() + prise;
    }

    @Override
    public boolean isSpecial() {
        return false;
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
