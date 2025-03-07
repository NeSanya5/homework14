package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

public class Article implements Searchable {
    String title;
    String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
@Override
    public String getName() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
    }
}
