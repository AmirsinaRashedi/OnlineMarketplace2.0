package util;

import repository.impl.AddressRepositoryImpl;
import repository.impl.ProductRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class ApplicationContext {

    public static final EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();

    public static UserRepositoryImpl userRepository;

    public static ProductRepositoryImpl productRepository;

    public static AddressRepositoryImpl addressRepository;

    private static SecurityContext securityContext;

    static {
        resetAll();
    }

    private static void resetAll() {

        userRepository = new UserRepositoryImpl(emf);

        productRepository = new ProductRepositoryImpl(emf);

        addressRepository = new AddressRepositoryImpl(emf);

    }

    public static SecurityContext getSecurityContext() {
        return securityContext;
    }
}
