package io.sowmoussa.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Item> items = new HashMap<String, Item>();
    
    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        Item item = null;
        try {
            item = (Item)(items.get(type)).clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Sembene");
        movie.setUrl("www.galsen.sn");
        movie.setPrice(10.99);
        movie.setRuntime("3 hours");
        items.put("Movie", movie);


        Book book = new Book();
        book.setTitle("Mbëk mi");
        book.setPrice(5.99);
        book.setUrl("www.mbekmi.sn");
        book.setNumberOfPages(100);
        items.put("Book", book);
    }
}
