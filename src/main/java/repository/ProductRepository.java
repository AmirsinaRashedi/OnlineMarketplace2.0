package repository;

import base.repository.BaseRepository;
import domain.Order;
import domain.Product;

import java.util.ArrayList;

public interface ProductRepository extends BaseRepository<Product, Long> {

    ArrayList<Product> getAllProducts();

    void printFromListWithTotal(ArrayList<Order> items);


}
