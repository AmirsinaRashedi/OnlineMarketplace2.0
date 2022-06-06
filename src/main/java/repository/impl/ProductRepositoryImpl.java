package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.*;
import repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product, Long>
        implements ProductRepository {

    private EntityManagerFactory emf;

    public ProductRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
        this.emf = emf;
    }

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public ArrayList<Product> getAllProducts() {

        EntityManager em = emf.createEntityManager();

        ArrayList<Product> stock = new ArrayList<>();

        TypedQuery<Shoes> selectShoesQuery = em.createQuery("from Shoes ", Shoes.class);

        stock.addAll(selectShoesQuery.getResultList());

        TypedQuery<Electronics> selectElectronicsQuery = em.createQuery("from Electronics ", Electronics.class);

        stock.addAll(selectElectronicsQuery.getResultList());

        TypedQuery<Litterateur> selectLitterateurQuery = em.createQuery("from Litterateur ", Litterateur.class);

        stock.addAll(selectLitterateurQuery.getResultList());

        em.close();

        return stock;

    }

    @Override
    public void printFromListWithTotal(ArrayList<Order> items) {

        int totalSum = 0;

        for (Order item : items) {

            totalSum += item.getProduct().getPricePerUnit() * item.getQuantity();

            System.out.println(item.getProduct() + "  quantity: " + item.getQuantity()
                    + "  price: " + item.getProduct().getPricePerUnit() * item.getQuantity());

        }

    }
}
