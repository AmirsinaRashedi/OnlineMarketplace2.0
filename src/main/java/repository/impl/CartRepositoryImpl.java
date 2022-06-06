package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Cart;
import domain.Product;
import repository.CartRepository;

import javax.persistence.EntityManagerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CartRepositoryImpl extends BaseRepositoryImpl<Product, Long>
        implements CartRepository {

    private EntityManagerFactory emf;

    private Cart cart;

    public CartRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
        this.emf = emf;
    }

    @Override
    public Class<Product> getClassType() {

        return Product.class;
    }

    @Override
    public void proceedToCheckout() {

        cart.resetCart();

    }

    @Override
    public void startShopping() {

        Scanner intInput = new Scanner(System.in);
        int choice;

        while (true) {
            menu.showShoppingMenu();

            try {
                choice = intInput.nextInt();

                switch (choice) {

                    case 1:
                        int productId = productRepository.printAllProducts();

                        System.out.print("type the id of the product you want to add: ");
                        choice = intInput.nextInt();

                        if (choice > 0 && choice <= productId) {

                            System.out.print("enter the quantity of your purchase: ");
                            int choiceAmount = intInput.nextInt();

                            if (choiceAmount > 0 && choiceAmount <= productRepository.checkAvailableAmount(choice)) {

                                int addArgument[] = {choice, choiceAmount};

                                if (cart.addToCart(addArgument))
                                    System.out.println("item added to cart");
                                else
                                    System.out.println("cart is full");

                            } else

                                System.out.println("invalid amount");

                        } else

                            System.out.println("item not found");

                        break;

                    case 2:

                        int count = 0;

                        for (int[] item : cart.getItems()) {

                            count++;

                            System.out.print(count + "- ");

                            productRepository.printProductFromCart(item);

                        }

                        if (count > 0) {
                            System.out.print("select an item to remove: ");
                            choice = intInput.nextInt();
                        }

                        if (choice > 0 && choice < count)
                            cart.removeFromCart(choice);
                        else
                            System.out.println("invalid choice");

                    case 3:

                        int count = 0, totalPrice = 0;

                        for (int[] item : cart.getItems()) {

                            count++;

                            System.out.print(count + "- ");

                            totalPrice += productRepository.printProductFromCart(item);

                        }

                        if (count > 0)
                            System.out.println("totalPrice: " + totalPrice);

                        break;

                    case 4:

                        cart.checkout();

                        return;

                    case 5:

                        proceedToCheckout();

                        return;

                    default:

                        break;

                }

            } catch (InputMismatchException e) {

                System.out.println("wrong input!");

            }

        }

    }

    @Override
    public void addToCart(Product item) {

    }
}
