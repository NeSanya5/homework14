package org.skypro.skyshop.searchEngine;

import java.util.Comparator;

public class SearchEngineComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            o1.compareTo(o2);
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
