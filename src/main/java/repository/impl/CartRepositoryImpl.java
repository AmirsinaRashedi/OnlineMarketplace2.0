package repository.impl;

import domain.Cart;
import domain.Order;
import domain.Product;
import repository.CartRepository;
import util.ApplicationContext;
import util.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CartRepositoryImpl
        implements CartRepository {

    private Cart cart;

    public CartRepositoryImpl(Cart cart) {
        this.cart = cart;
    }


    @Override
    public void proceedToCheckout() {

        cart.resetCart();

    }

    @Override
    public void dontCheckout() {

        for (Order order : cart.getItems()) {

            Product product = order.getProduct();

            product.setAvailableUnits(product.getAvailableUnits() + order.getQuantity());

            ApplicationContext.productRepository.update(product);

        }

        cart.resetCart();

    }

    @Override
    public void startShopping() {

        Scanner intInput = new Scanner(System.in);
        int choice;

        while (true) {
            Menu.showShoppingMenu();

            try {
                choice = intInput.nextInt();

                switch (choice) {

                    case 1:

                        int maxProductId = 0;

                        ArrayList<Product> stock =
                                ApplicationContext.productRepository.getAllProducts();

                        for (Product item : stock) {

                            System.out.println(++maxProductId + "  " + item);

                        }

                        System.out.print("type the id of the product you want to add: ");
                        choice = intInput.nextInt();

                        if (choice > 0 && choice <= maxProductId) {

                            System.out.print("enter the quantity of your purchase: ");
                            int choiceAmount = intInput.nextInt();

                            if (choiceAmount > 0 && choiceAmount <= stock.get(choice - 1).getAvailableUnits()) {

                                try {

                                    cart.addItem(new Order(stock.get(choice - 1), choiceAmount));

                                    stock.get(choice - 1).setAvailableUnits(stock.get(choice - 1).getAvailableUnits() - choiceAmount);

                                    ApplicationContext.productRepository.update(stock.get(choice - 1));

                                } catch (Exception e) {

                                    System.out.println(e.getMessage());

                                }

                            } else

                                System.out.println("invalid amount");

                        } else

                            System.out.println("item not found");

                        break;

                    case 2:

                        int count = 0;

                        for (Order order : cart.getItems()) {

                            System.out.print(++count + "- " + order);

                        }

                        if (count > 0) {
                            System.out.print("select an item to remove: ");
                            choice = intInput.nextInt();

                            if (choice > 0 && choice < count)

                                cart.removeItem(choice - 1);

                            else

                                System.out.println("invalid choice");

                        }

                        break;

                    case 3:

                        int itemCount = 0, totalPrice = 0;

                        for (Order item : cart.getItems()) {

                            System.out.print(++itemCount + "- " + item.getProduct()
                                    + "   price: " + item.getQuantity() * item.getProduct().getPricePerUnit());

                            totalPrice += item.getQuantity() * item.getProduct().getPricePerUnit();

                        }

                        if (itemCount > 0)
                            System.out.println("totalPrice: " + totalPrice);

                        break;

                    case 4:

                        dontCheckout();

                        return;

                    case 5:

                        proceedToCheckout();

                        return;

                    default:

                        break;

                }

            } catch (Exception e) {

                System.out.println("wrong input!");

            }

        }

    }

}
