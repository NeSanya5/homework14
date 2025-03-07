package org.skypro.skyshop.searchEngine;


public class SearchEngine {
    private static int quantity;

    public SearchEngine(int quantity) {
        this.quantity = quantity;
    }

    private static Searchable[] searchables = new Searchable[quantity];
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
