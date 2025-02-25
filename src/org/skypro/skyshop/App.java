package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        ProductBasket.addProductInBasket("Носки",200);
        ProductBasket.addProductInBasket("Кофта",1500);
        ProductBasket.addProductInBasket("Куртка",8700);
        ProductBasket.addProductInBasket("Футболка",1200);
        ProductBasket.addProductInBasket("Валенки",2000);
        ProductBasket.addProductInBasket("Кросовки",2000);

        ProductBasket.printBasket();
        System.out.println(ProductBasket.productVerification("Носки"));
        System.out.println(ProductBasket.productVerification("Кросовки"));
        ProductBasket.cleanBasket();
        ProductBasket.printBasket();
        System.out.println(ProductBasket.generalPrice());
        System.out.println(ProductBasket.productVerification("Носки"));

    }
}