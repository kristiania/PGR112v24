package solutions.projects.commerce.store.src;


public class Main
{
    public static void main(String[] args) {
        Employee owner = new Employee();


        Store store = new Store(
                "Navn på butikken",
                owner
        );


        Customer customer1 = new Customer(750);
        Customer customer2 = new Customer(750);


        //# 1) Create products available for purchase
        Product banana = new Product("Banan", 10);
        Product apple = new Product("Eple", 7);


        //# 2) Add products to customer's shopping cart
        customer1.getShoppingCart().put(banana, 42);
        customer1.getShoppingCart().put(apple, 14);

        customer2.getShoppingCart().put(banana, 20);
        customer2.getShoppingCart().put(apple, 64);


        //# 3) Process the buying of products via the cash register
        //# 4) If the sale is successful,
        // make sure a receipt generated and added to the cash register

        // ---

        // Process two customers and afterward print out all receipts
        // and the total income earned

        System.out.println("---");
        System.out.println(STR."First customer wallet: kr \{customer1.getMoney()},-");

        if (store.getCashRegister().processCustomer(customer1)) {
            System.out.println("First customer successfully bought their products");
            System.out.println(STR."First customer have the following left in their wallet: kr \{customer1.getMoney()},-");
        }
        else {
            System.out.println("First customer did not have enough money to succeed in purchasing what they wanted");
        }

        System.out.println("---");
        System.out.println(STR."Second customer wallet: kr \{customer2.getMoney()},-");

        if (store.getCashRegister().processCustomer(customer2)) {
            System.out.println("Second customer successfully bought their products");
            System.out.println(STR."First customer have the following left in their wallet: kr \{customer2.getMoney()},-");
        }
        else {
            System.out.println("Second customer dit not have enough money to buy all those apples");
        }


        // Print out receipts to see if they match what we think it should

        System.out.println("---");
        System.out.println("Store receipts:");

        for (Receipt receipt : store.getCashRegister().getReceipts()) {
            // see toString()-method in Receipt-class
            System.out.println(receipt);
        }

        System.out.println("---");
        System.out.print(STR."Total earnings for the store: kr \{store.getCashRegister().totalEarnings()},-");

        // Extra:
        // 1) Create custom exceptions for certain situations,
        // for example: not enough money in customer wallet
        // 2) Make sure any values of money can not be negative
        // 3) Make use of:
        //      @Override
        //      public String toString() { ... } in all of the classes
    }
}
