package org.skypro.skyshop.searchEngine;

public class BestResultNotFound extends Exception{
    String serch;

    public BestResultNotFound(String serch) {
        this.serch = serch;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{" +
                "serch='" + serch + " не нашлось подходящей статьи.";
    }
}
