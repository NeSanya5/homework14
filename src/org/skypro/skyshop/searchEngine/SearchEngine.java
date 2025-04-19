package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private static Map<String, Searchable> searchables = new HashMap<>();

    public static void add(Searchable searchable) {
        searchables.put(searchable.getName(), searchable);
    }

    public static Map<String, Searchable> search(String search) {
        Map<String, Searchable> result = new HashMap<>();
        for (Map.Entry<String, Searchable> searchable: searchables.entrySet()) {
            if (searchable != null && searchable.getKey().equals(search)) {
                result.put(searchable.getKey(),searchable.getValue());
            }
        }
        if (result.size() == 0) {
            System.out.println("Поиск неудался");
        }
        return result;
    }

    public static Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable result = null;

        for (Map.Entry<String, Searchable> searchable: searchables.entrySet()) {
            if (searchable != null && searchable.getKey().equals(search)) {
                result = searchable.getValue();
            }
        }
        if (result == null) {
            throw new BestResultNotFound(search);
        }

        return result;
    }
}
