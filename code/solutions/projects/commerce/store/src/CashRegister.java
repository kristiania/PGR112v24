package solutions.projects.commerce.store.src;

import java.util.ArrayList;
import java.util.HashMap;

public class CashRegister
{
    //# Fields
    private int money;
    private Employee employee;
    private final ArrayList<Receipt> receipts;


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

            //# 4) Create a receipt
            // here a new HashMap is used as we cannot use the same object that
            // represents the customers' cart - if the customer startet to shop again
            // this receipt would then reflect that object and not a "snapshot" of what
            // the customer paid for in terms of buying the products and getting a recept
            Receipt receipt = new Receipt(new HashMap<>());

            // add products from cart to the receipt
            for (Product product : cart.keySet()) {
                receipt.getProducts().put(product, cart.get(product));
            }

            //# 3.3) Clear products from customer cart
            // BUT! do it after receipt has new overview of the products from the cart
            cart.clear();

            //# 5) Print the receipt to the terminal
            System.out.println("Kvittering:");

            for (Product product : receipt.getProducts().keySet()) {
                int quantity = receipt.getProducts().get(product);

                System.out.println(
                        STR."\{product.getName()} x\{quantity} = \{product.getPrice()*quantity}"
                );
            }

            this.getReceipts().add(receipt);

            System.out.println(STR."Totalpris =  \{totalPrice}");

            //# 6) return true
            return true;
        }

        //# 3) else:
        return false;
    }

    int totalEarnings() {
        // go through each receipt and sum up all income and return result
        int totalIncome = 0;

        for (Receipt receipt : this.getReceipts()) {
            totalIncome += receipt.totalPrice();
        }

        return totalIncome;
    }
}
