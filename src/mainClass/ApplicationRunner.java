package mainClass;

import database.Database;
import database.ItemNotFoundException;
import entity.*;
import enums.City;
import enums.Color;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) throws ItemNotFoundException{
        Scanner scan = new Scanner(System.in);
        Database database = new Database();
        Item item1 = new Item(1, "Macbook", Color.BLACK, 1500);
        Item item2 = new Item(2, "IPhone", Color.GREEN, 1200);
        Item item3 = new Item(3, "Samsung", Color.RED, 800);
        Item item4 = new Item(4, "Mouse", Color.BLACK, 100);
        database.addItem(item1);
        database.addItem(item2);
        database.addItem(item3);
        database.addItem(item4);
        System.out.println("You need to register in order to shop...");
        System.out.print("Please enter your name : ");
        String firstName = scan.nextLine();

        System.out.print("Please enter your last name : ");
        String lastName = scan.nextLine();

        System.out.print("Enter your address..: ");
        String address = scan.nextLine();

        System.out.println("Select the city you live in..:");
        for (int i = 0; i < City.values().length; i++) {
            System.out.println(i + " for " + City.values()[i]);
        }
        int chosenCity = scan.nextInt();

        System.out.print("Zipcode..: ");
        String zipCode = scan.next();

        System.out.print("Please set your username : ");
        String userName = scan.next();

        System.out.print("Please set your password :");
        String password = scan.next();

        User currentUser = new User(firstName, lastName, userName, password, new Address(address, City.values()[chosenCity], zipCode));
        database.addUser(currentUser);
        System.out.println("The registration process has been completed successfully... We wish you a pleasant shopping...");

        Cart shoppingCart = new Cart();
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Please add your product to CART by making your selection....");
            System.out.println("---------------------------------------------------");
            for (int i = 0; i < database.getAllItems().size(); i++) {
                System.out.println("For " + database.getAllItems().get(i).getName() + " type " + (i + 1) + " and press ENTER");
            }
            final int chosenItemId = scan.nextInt();
            final Item chosenItem = database.findItemById(chosenItemId);
            System.out.println("How many pieces do you want to buy in the selected product " + chosenItem.getName() + "?");
            final int chosenItemCount = scan.nextInt();
            shoppingCart.addToCart(new CartItem(chosenItem, chosenItemCount));
            System.out.println("There is product/s worth " + shoppingCart.getTotalCartCost() + " USD in your cart....");
            boolean isInputValid = true;
            while (isInputValid) {
                System.out.println("Press 1 to complete the purchase, press 2 to continue");
                final int userChoice = scan.nextInt();

                switch (userChoice) {
                    case 1: {
                        System.out.println("Your payment is successful... Thank you for choosing us");
                        System.out.println("Your product/s will be shipped to '" + currentUser.getAddress().
                                getDescription() + " " + City.values()[chosenCity] + "' address.");
                        shoppingCart.emptyCart();
                        isInputValid = false;
                        continueShopping = false;
                        break;
                    }
                    case 2: {
                        isInputValid = false;
                        break;
                    }
                    default:
                        System.out.println("You did not make a valid choice...");
                }
            }
        }
    }
}
