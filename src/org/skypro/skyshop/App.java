package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
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

    }
}