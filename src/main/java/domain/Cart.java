package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item) {

        if (items.size() < 6)

            items.add(item);

        else

            throw new IndexOutOfBoundsException("cart is full");

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
