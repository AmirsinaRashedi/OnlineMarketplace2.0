package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item) {

        items.add(item);

    }

    public void removeItem(int index) {

        items.remove(index);

    }

    public List<Product> getItems() {
        return items;
    }

    public Integer getItemCount() {

        return items.size();

    }
}
