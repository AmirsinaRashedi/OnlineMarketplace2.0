package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("OnlineMarketplace");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
