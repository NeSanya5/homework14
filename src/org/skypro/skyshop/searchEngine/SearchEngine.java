package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {

    private static Set<String> searchables = new HashSet<>();

    public static void add(Searchable searchable) {
        searchables.add(searchable.getName());
    }

    public static Set<String> search(String search) {
        TreeSet<String> result = searchables.stream()
                .filter(i -> i == search)
                .collect(Collectors.toCollection(() ->new TreeSet<>(new SearchEngineComparator())));
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

