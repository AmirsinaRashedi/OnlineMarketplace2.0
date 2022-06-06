package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders;

    public Cart() {
        orders = new ArrayList<>();
    }

    public void addItem(Order order) {

        if (orders.size() < 6)

            orders.add(order);

        else

            throw new IndexOutOfBoundsException("cart is full");

    }

    public void removeItem(int index) {

        orders.remove(index);

    }

    public List<Order> getItems() {
        return orders;
    }

    public Integer getItemCount() {

        return orders.size();

    }

    public void resetCart() {
        orders = new ArrayList<>();
    }
}
