package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;


public class ProductBasket {
    private static Map<String, List<Product>> product = new HashMap<>();

    public static void addProductInBasket(Product products) {
        product.computeIfAbsent(products.getNameProduct(), k -> new ArrayList<>()).add(products);
    }

    //Напечатать корзину
    public static void printBasket() {
        if (product.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            product.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            System.out.println("Итого : " + generalPrice());
            System.out.println("Специальных товаров: " + quantitySpecialProduct());
        }


    }

    //Общая стоимость
    public static int generalPrice() {
        return product.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    //boolean поиск продукта
    public static boolean productVerification(String name) {
        return product.values().stream().
                flatMap(Collection::stream)
                .anyMatch(i -> i.getNameProduct().equals(name));
    }

    //Очистка корзины
    public static void cleanAllBasket() {
        product.clear();
    }

    //Удаление продукта из екорзины
    public static List<Product> cleanProductBasket(String name) {
        List<Product> result = product.values().stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getNameProduct().equals((name)))
                .toList();
        product.keySet().removeIf(key -> key.equals(name));

        return result;
    }

    //Колиство спец продуктов
    public static long quantitySpecialProduct() {
        return product.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


}
