package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.searchEngine.BestResultNotFound;
import org.skypro.skyshop.searchEngine.SearchEngine;

import java.util.Arrays;

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
        ProductBasket.cleanBasket();
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
        System.out.println(Arrays.toString(searchEngine.search("Очки")));
        System.out.println(Arrays.toString(searchEngine.search("Носки")));
        System.out.println(Arrays.toString(searchEngine.search("Куртка")));
        System.out.println(Arrays.toString(searchEngine.search("Кофта")));
        System.out.println(Arrays.toString(searchEngine.search("Яблоко")));
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

    }
}