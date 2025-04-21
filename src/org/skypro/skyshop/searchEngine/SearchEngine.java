package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private static Set<String> searchables = new HashSet<>();

    public static void add(Searchable searchable) {
        searchables.add(searchable.getName());
    }

    public static Set<String> search(String search) {
        Set<String> result = new TreeSet<>(new SearchEngineComparator());
        for (String searchable : searchables){
            if (searchable != null && searchable.contains(search)) {
                result.add(searchable);
            }
        }
        if (result.size() == 0) {
            System.out.println("Поиск неудался");
        }
        return result;
    }

    public static  String getSearchTerm(String search) throws BestResultNotFound {
        String result = null;

        for (String searchable : searchables) {
            if (searchable != null && searchable.contains(search)) {
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFound(search);
        }

        return result;
    }
}

