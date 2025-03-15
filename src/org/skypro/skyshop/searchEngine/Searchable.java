package org.skypro.skyshop.searchEngine;

public interface Searchable {
    String searchTerm();
    String getContentType();
    String getName();
    default String getStringRepresentation() {
        return getName() + " " + getContentType();
    }
}
