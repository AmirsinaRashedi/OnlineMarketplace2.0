package repository;

import base.repository.BaseRepository;
import domain.Product;

public interface CartRepository extends BaseRepository<Product, Long> {

    void proceedToCheckout();

    void startShopping();

    void addToCart(Product item);

}
