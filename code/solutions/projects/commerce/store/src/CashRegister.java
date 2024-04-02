package solutions.projects.commerce.store.src;

import java.util.ArrayList;
import java.util.HashMap;

public class CashRegister
{
    //# Fields
    private int money;
    private Employee employee;
    private ArrayList<Receipt> receipts;


    //# Constructor
    CashRegister(Employee employee) {
        this.money = 0;
        this.employee = employee;
        this.receipts = new ArrayList<>();
    }


    //# Getter-methods
    int getMoney() {
        return this.money;
    }

    Employee getEmployee() {
        return this.employee;
    }

    int getEmployeeNumber() {
        return this.getEmployee().getEmployeeNumber();
    }

    ArrayList<Receipt> getReceipts() {
        return this.receipts;
    }


    //# Methods
    boolean processCustomer(Customer customer) {
        //# 1) Get total price of all products in cart
        HashMap<Product, Integer> cart = customer.getShoppingCart();
        int totalPrice = 0;

        for (Product product : cart.keySet()) {
            totalPrice += product.getPrice()*cart.get(product);
        }

        //# 2) Check if customer has enough money in wallet
        if (customer.getWallet().getMoney() >= totalPrice) {
            //# 3) If customer has enough money:

            //# 3.1) Remove money from wallet
            customer.getWallet().removeMoney(totalPrice);

            //# 3.2) Add money to cash register
            this.money += totalPrice;

            //# 3.3) Clear products from customer cart

            //# 4) Create a receipt
            Receipt receipt = new Receipt(new HashMap<>());

            for (Product product : cart.keySet()) {
                receipt.getProducts().put(product, cart.get(product));
            }

            cart.clear();

            //# 5) Print the receipt to the terminal
            System.out.println("Kvittering:");

            for (Product product : receipt.getProducts().keySet()) {
                int quantity = receipt.getProducts().get(product);

                System.out.printf(
                        "%s x%d = %d%n",
                        product.getName(),
                        quantity,
                        product.getPrice()*quantity
                );
            }

            System.out.println("Total price: " + totalPrice);

            //# 6) return true
            return true;
        }

        //# 3) else:
        return false;
    }

    int totalEarnings() {
        // TODO go through each receipt and sum up all income and return result
        return 0;
    }
}
