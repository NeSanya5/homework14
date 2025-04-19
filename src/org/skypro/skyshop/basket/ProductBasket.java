package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private static Map<String, List<Product>> product = new HashMap<>();
    private static int quantitySpecialProduct = 0;

    public static void addProductInBasket(Product products) {
        product.computeIfAbsent(products.getNameProduct(), k -> new ArrayList<>()).add(products);
    }

    public static void printBasket() {
        if (product.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            for (Map.Entry<String, List<Product>> entry : product.entrySet()) {
                List<Product> products = entry.getValue();
                for (Product pro : products) {
                    if (pro == null) {
                        continue;
                    }
                    System.out.println(pro);
                }
                System.out.println("Итого : " + generalPrice());
                System.out.println("Специальных товаров: " + quantitySpecialProduct());
            }
        }


    }

    public static int generalPrice() {
        int generalPrice = 0;
        for (Map.Entry<String, List<Product>> entry : product.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product pro : products) {
                generalPrice = generalPrice + pro.getPrice();
            }
        }
        return generalPrice;
    }

    public static boolean productVerification(String name) {
        boolean productVerification = false;

        for (Map.Entry<String, List<Product>> entry : product.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product pro : products) {
                if (pro == null) {
                    continue;
                } else if (pro.getNameProduct().equals(name)) {
                    productVerification = true;
                }
            }
        }
        return productVerification;
    }

    public static void cleanAllBasket() {
        product.clear();
    }

    public static List<Product> cleanProductBasket(String name) {
        List<Product> result = new LinkedList<>();

        for (Map.Entry<String, List<Product>> entry : product.entrySet()) {
            List<Product> products = entry.getValue();
            Iterator<Product> iterator = products.iterator();
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
        }
        return result;
    }

    public static int quantitySpecialProduct() {

        for (Map.Entry<String, List<Product>> entry : product.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product pro : products) {
                if (pro.isSpecial()) {
                    quantitySpecialProduct++;
                }
            }
        }
        return quantitySpecialProduct;
    }


}
