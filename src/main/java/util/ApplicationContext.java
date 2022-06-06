package util;

import repository.UserRepository;

import javax.persistence.EntityManagerFactory;

public class ApplicationContext {

    public static final EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();

    public static UserRepository userRepository;

    static {
        resetAll();
    }

    private static void resetAll() {

    }


}
