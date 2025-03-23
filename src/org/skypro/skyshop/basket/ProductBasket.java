package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;


public class ProductBasket {
    private static List<Product> product = new LinkedList<>();
    private static int number = 0;
    private static int quantitySpecialProduct = 0;

    public static void addProductInBasket(Product products) {
        product.add(products);
        number++;
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
            System.out.println("Специальных товаров: " + quantitySpecialProduct());
        }
    }

    public static boolean productVerification(String name) {
        boolean productVerification = false;
        for (Product pro : product) {
            if (pro == null) {
                continue;
            } else if (pro.getNameProduct().equals(name)) {
                productVerification = true;
            }
        }
        return productVerification;
    }

    public static void cleanAllBasket() {
        while (product.size() != 0) {
            product.remove(0);
        }
    }

    public static List<Product> cleanProductBasket(String name) {
        List<Product> result = new LinkedList<>();
        Iterator<Product> iterator = product.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getNameProduct().equals(name)) {
                result.add(element);
                iterator.remove();
            }
        }
        if (result.size() == 0) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Товары удалены :");
        }
        return result;
    }

    public static int quantitySpecialProduct() {
        for (Product pro : product) {
            if (pro.isSpecial()) {
                quantitySpecialProduct++;
            }
        }
        return quantitySpecialProduct;
    }


}
