package projects.commerce.store.src;

import java.util.ArrayList;

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

        //# 2) Check if customer has enough money in wallet

        //# 3) If customer has enough money:
            //# 3.1) Remove money from wallet
            //# 3.2) Add money to cash register
            //# 3.3) Clear products from customer cart

            //# 4) Create a receipt

            //# 5) Print the receipt to the terminal

            //# 6) return true

        //# 3) else:
        return false;
    }

    int totalEarnings() {
        // TODO go through each receipt and sum up all income and return result
        return 0;
    }
}
