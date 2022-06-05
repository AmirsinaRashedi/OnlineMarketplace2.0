package base.repository.impl;

import base.domain.BaseEntity;
import base.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;

public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<T, ID> {

    private final EntityManagerFactory emf;
    private EntityManager em;

    public BaseRepositoryImpl(EntityManagerFactory emf) {

        this.emf = emf;

    }

    @Override
    public void save(T t) {

        em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(t);

            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());

            em.getTransaction().rollback();

        } finally {

            em.close();

        }
    }

    @Override
    public T update(T t) {

        T newEntity;

        em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            newEntity = em.merge(t);

            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println("wrong entity");

            em.getTransaction().rollback();

            newEntity = t;

        } finally {

            em.close();

        }

        return newEntity;

    }

    @Override
    public void delete(T t) {

        em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            t = em.find(getClassType(), t.getId());

            em.remove(t);

            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());

            em.getTransaction().rollback();

        } finally {

            em.close();

        }

    }

    @Override
    public T find(T t) {
        return null;
    }

    @Override
    public T findById(ID id) {

        T newEntity;

        em = emf.createEntityManager();

        newEntity = em.find(getClassType(), id);

        em.close();

        return newEntity;
    }

    public abstract Class<T> getClassType();
}
