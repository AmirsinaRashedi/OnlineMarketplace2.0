package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.User;
import repository.AddressRepository;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long>
        implements UserRepository {

    private EntityManagerFactory emf;

    public UserRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
        this.emf = emf;
    }

    @Override
    public Class<User> getClassType() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {

        User newUser;

        EntityManager em = emf.createEntityManager();

        String fromUserQuery = "from User where username = :user_name";

        TypedQuery<User> query = em.createQuery(fromUserQuery, User.class);

        query.setParameter("user_name", username);

        newUser = query.getSingleResult();

        return newUser;
    }

    @Override
    public User loginToUser() {
        return null;
    }

    @Override
    public User defineNewUser() {

        User user = new User();

        Scanner stringInput = new Scanner(System.in);

        System.out.print("enter username: ");

        String newUsername = stringInput.nextLine();


        if (findByUsername(newUsername) == null) {

            user.setUsername(newUsername);

            System.out.print("enter a password: ");
            user.setPassword(stringInput.nextLine());

            System.out.print("enter your first name: ");
            user.setRealName(stringInput.nextLine());

            System.out.print("enter your last name: ");
            user.setLastName(stringInput.nextLine());

            System.out.print("enter your phone number: ");
            user.setPhoneNumber(stringInput.nextLine());

            System.out.print("enter your E-mail: ");
            user.setEmail(stringInput.nextLine());

            AddressRepository addressRepository = new AddressRepositoryImpl(emf);
            user.setAddress(addressRepository.createAddress());

            user = save(user);

            return user;

        } else {

            System.out.println("this username is taken");

            return null;

        }
    }
}
