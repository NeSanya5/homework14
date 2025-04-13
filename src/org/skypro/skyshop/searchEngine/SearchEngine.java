package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private static List<Searchable> searchables = new LinkedList<>();
    private static int number = 0;

    public static void add(Searchable searchable) {
            searchables.add(searchable);
            number++;
    }

    public static List<Searchable> search(String search) {
        List<Searchable> result = new LinkedList<>();
       int count = 0;
       for (Searchable searchable : searchables){
           if (searchable != null && searchable.searchTerm().contains(search)) {
               result.add(searchable);
           }
       }
        if (result.size() == 0) {
            System.out.println("Поиск неудался");
        }
       return result;
    }

    public static  Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable result = null;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(search)) {
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFound(search);
        }

        return result;
    }
}
