package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private static Product[] product = new Product[5];
    private static int number = 0;

    public static void addProductInBasket(String name, int price) {
        if (number == 5) {
            System.out.println("Невозможно добавить");
        } else {
            product[number] = new Product(name, price);
            number++;
        }
    }

    public static int generalPrice() {
        int generalPrice = 0;
        for (Product pro : product) {
            if (pro == null) {
                continue;
            }
            generalPrice = generalPrice + pro.getPrice();
        }
        return generalPrice;
    }

    public static boolean basketFilled() {
        boolean basketFilled = false;
        for (Product pro : product) {
            if (pro == null) {
                continue;
            } else {
                basketFilled = true;
            }
        }
        return basketFilled;
    }

    public static void printBasket() {
        for (Product pro : product) {
            if (pro == null) {
                continue;
            }
            System.out.println(pro);
        }
        if (ProductBasket.basketFilled() == false) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого : " + generalPrice());
        }
    }

    public static boolean productVerification(String name) {
        boolean productVerification = false;
        for (Product pro : product) {
            if (pro == null) {
                continue;
            } else if (pro.getName().equals(name)) {
                productVerification = true;
            }
        }
        return productVerification;
    }

    public static void cleanBasket() {
        for (number = 0; number < product.length; number++) {
            product[number] = null;
        }
    }


}
