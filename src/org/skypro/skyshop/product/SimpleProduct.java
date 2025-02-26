package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int prise;

    public SimpleProduct(String name, int prise) {
        super(name);
        this.prise = prise;
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
}
