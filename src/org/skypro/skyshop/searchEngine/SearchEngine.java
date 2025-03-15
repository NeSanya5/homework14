package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.product.Product;

public class SearchEngine {

    private static Searchable[] searchables = new Searchable[5];
    private static int number = 0;

    public static void add(Searchable searchable) {
        if (number == 5) {
            System.out.println("Невозможно добавить");
        } else {
            searchables[number] = searchable;
            number++;
        }
    }

    public static Searchable[] search(String search) {
       Searchable[] result = new Searchable[5];
       int count = 0;
       for (Searchable searchable : searchables){
           if (count >= 5) {
               break;
           }
           if (searchable != null && searchable.searchTerm().contains(search)) {
               result[count++] = searchable;
           }
       }
       return result;
    }
}
