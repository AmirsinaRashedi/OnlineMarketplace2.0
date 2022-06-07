import util.ApplicationContext;
import util.Menu;

import java.util.Scanner;

public class OnlineMarketplaceApplication {
    public static void main(String[] args) {

        Scanner intInput = new Scanner(System.in);


        while (true) {

            ApplicationContext.getSecurityContext().logout();

            Menu.showWelcomeMenu();

            System.out.print("choose: ");

            int choice = intInput.nextInt();

            switch (choice) {

                case 1:

                    ApplicationContext.getSecurityContext().setCurrentUser(ApplicationContext.userRepository.defineNewUser());

                    if (ApplicationContext.getSecurityContext().getCurrentUser() != null)
                        ApplicationContext.getSecurityContext().getCurrentUser().getCartRepository().startShopping();

                    break;

                case 2:

                    ApplicationContext.getSecurityContext().setCurrentUser(ApplicationContext.userRepository.loginToUser());

                    if (ApplicationContext.getSecurityContext().getCurrentUser() != null)
                        ApplicationContext.getSecurityContext().getCurrentUser().getCartRepository().startShopping();

                    break;

                case 3:
                    return;

            }

        }
    }
}
