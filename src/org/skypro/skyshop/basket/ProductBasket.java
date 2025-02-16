package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import javax.swing.plaf.PanelUI;

public class ProductBasket {
    private static Product[] product = new Product[5];
    private static int i = 0;

    public static void addProductInBasket(String name, int price) {
        if (i == 5) {
            System.out.println("Невозможно добавить");
        } else {
            product[i] = new Product(name, price);
            i++;
        }
    }

    public static int generalPrice() {
        i = 0;
        int generalPrice = 0;
        for (; i < product.length; i++) {
            if (product[i] == null) {
                continue;
            }
            generalPrice = generalPrice + product[i].getPrice();
        }
        return generalPrice;
    }

    public static void printBasket() {
        boolean basketFilled = false;
        for (Product pro : product) {
            if (pro == null) {
                continue;
            }
            basketFilled = true;
            System.out.println(pro);
        }
        if (basketFilled == false) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого : " + generalPrice());
        }
    }

    public static boolean productVerification(String name) {
        boolean productVerification = false;
        for (Product pro : product) {
            if (pro == null || pro.getName() != name) {
                continue;
            } else if (pro.getName() == name) {
                productVerification = true;
            }
        }
        return productVerification;
    }

    public static void cleanBasket() {
        i = 0;
        for (; i < product.length; i++) {
            product[i] = null;
        }
    }


}
