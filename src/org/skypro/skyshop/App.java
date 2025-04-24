package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.searchEngine.BestResultNotFound;
import org.skypro.skyshop.searchEngine.SearchEngine;

import java.util.Arrays;

import static org.skypro.skyshop.basket.ProductBasket.cleanProductBasket;

public class App {
    public static void main(String[] args) {
        System.out.println("Проверка корзины");
        Product socks = new SimpleProduct ("Носки",200);
        Product cardigan = new FixPriceProduct("Кофта" );
        Product jacket = new DiscountedProduct ("Куртка",8700, 15);
        Product shirt = new DiscountedProduct ("Футболка",1200, 25);
        Product feltBoots = new FixPriceProduct("Валенки");
        Product sneakers = new SimpleProduct ("Кросовки",2000);

        ProductBasket.addProductInBasket(socks);
        ProductBasket.addProductInBasket(cardigan);
        ProductBasket.addProductInBasket(jacket);
        ProductBasket.addProductInBasket(shirt);
        ProductBasket.addProductInBasket(feltBoots);
        ProductBasket.addProductInBasket(sneakers);

        ProductBasket.printBasket();
        System.out.println(ProductBasket.productVerification("Носки"));
        System.out.println(ProductBasket.productVerification("Кросовки"));
        ProductBasket.cleanAllBasket();
        ProductBasket.printBasket();
        System.out.println(ProductBasket.generalPrice());
        System.out.println(ProductBasket.productVerification("Носки"));
        System.out.println();

        System.out.println("Проверка поисковой системы");

        System.out.println();
        Article glasses  = new Article("Очки", "Очки -3");
        Article blueSneakers = new Article("Кроссовки", "Кроссовки с размером 42, синего цвета");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(socks);
        searchEngine.add(cardigan);
        searchEngine.add(blueSneakers);
        searchEngine.add(glasses);
        searchEngine.add(jacket);
        searchEngine.add(shirt);
        System.out.println(searchEngine.search("Очки"));
        System.out.println(searchEngine.search("Носки"));
        System.out.println(searchEngine.search("Куртка"));
        System.out.println(searchEngine.search("Кофта"));
        System.out.println(searchEngine.search("Яблоко"));
        System.out.println();

        System.out.println("Проверка исключений");

        System.out.println();
        try {
            Product potato = new SimpleProduct("  ", 900);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product tomato = new SimpleProduct("Помидор", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product carrot = new DiscountedProduct("Морковь", 200, 110);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        try {
            System.out.println(searchEngine.getSearchTerm("Кофта"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        try {
            System.out.println(searchEngine.getSearchTerm("Яблоко"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("ДЗ 19");

        System.out.println();

        ProductBasket.addProductInBasket(socks);
        ProductBasket.addProductInBasket(cardigan);
        ProductBasket.addProductInBasket(jacket);
        ProductBasket.addProductInBasket(shirt);
        ProductBasket.addProductInBasket(feltBoots);
        ProductBasket.addProductInBasket(feltBoots);
        ProductBasket.addProductInBasket(feltBoots);
        ProductBasket.addProductInBasket(sneakers);

        ProductBasket.printBasket();

        System.out.println("Удалено" + cleanProductBasket("Валенки"));

        ProductBasket.printBasket();

        System.out.println("Удалено" + cleanProductBasket("картошка"));

        ProductBasket.printBasket();



    }
}