package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(title, ((Article) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
