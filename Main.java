import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //My product list and prices in arrays
        String[] products = {"Tomato", "Coffee", "Tea", "Chicken", "Beef", "Cheese", "Milk", "Bread", "Eggs", "Rice"};
        double[] prices = {2.50, 3.00, 2.00, 4.50, 5.00, 3.50, 2.00, 1.50, 2.00, 1.00};

        //Print the product list and prices
        System.out.println("Product List: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - €" + prices[i]);
        }

        // Create an array list to hold the ordered products
        ArrayList<OrderedProduct> orderedProducts = new ArrayList<>();

        //Ask the user to enter the product numbers and quantities
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter the product number you want to buy (or 'q' to finish): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            try {
                int index = Integer.parseInt(input.trim()) - 1;

                if (index >= 0 && index < products.length) {
                    System.out.println("Enter the quantity you want to buy: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume leftover newline character

                    OrderedProduct orderedProduct = new OrderedProduct(products[index], prices[index], quantity);
                    orderedProducts.add(orderedProduct);
                } else {
                    System.out.println("Error: Product number " + (index + 1) + " is out of range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + input.trim() + "\" is not a valid product number.");
                scanner.nextLine(); // consume leftover newline character
            }
        }

        // Sort the ordered products by price in descending order
        orderedProducts.sort(Collections.reverseOrder());

        // Display the ordered products in a table
        System.out.println("\nOrdered Products: ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Product\t\tPrice\t\tQuantity\tTotal");
        System.out.println("-----------------------------------------------------");

        double grandTotal = 0.0;

        for (OrderedProduct orderedProduct : orderedProducts) {
            double total = orderedProduct.getPrice() * orderedProduct.getQuantity();
            grandTotal += total;

            System.out.println(orderedProduct.getName() + "\t\t€" + orderedProduct.getPrice() + "\t\t" + orderedProduct.getQuantity() + "\t\t\t€" + total);
        }

        // Display the grand total
        System.out.println("-----------------------------------------------------");
        System.out.println("Total:\t\t\t\t\t\t\t€" + grandTotal);

        //At the bottom, also show the order total and count 21% VAT over all products.
        double vat = grandTotal * 0.21;
        System.out.println("VAT:\t\t\t\t\t\t\t€" + vat);
        System.out.println("Grand Total:\t\t\t\t\t€" + (grandTotal + vat));

        scanner.close();

    }
}

