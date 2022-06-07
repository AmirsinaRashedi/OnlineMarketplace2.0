package domain;

import util.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders;

    public Cart() {
        orders = new ArrayList<>();
    }

    public void addItem(Order order) {

        if (orders.size() < 5)

            orders.add(order);

        else

            throw new IndexOutOfBoundsException("cart is full");

    }

    public void removeItem(int index) {

        Product product = orders.get(index).getProduct();

        product.setAvailableUnits(product.getAvailableUnits() + orders.get(index).getQuantity());

        ApplicationContext.productRepository.update(product);

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
