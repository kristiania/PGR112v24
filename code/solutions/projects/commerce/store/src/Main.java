package solutions.projects.commerce.store.src;


public class Main
{
    public static void main(String[] args) {
        Employee owner = new Employee();

        Store store = new Store(
                "Navn på butikken",
                owner
        );

        Customer customer = new Customer(10000);

        //# 1) Create products available for purchase
        Product banana = new Product("Banan", 10);
        Product apple = new Product("Eple", 7);

        //# 2) Add products to customer's shopping cart
        customer.getShoppingCart().put(banana, 42);
        customer.getShoppingCart().put(apple, 100);

        //# 3) Process the buying of products via the cash register
        boolean success = store.getCashRegister().processCustomer(customer);

        //# 4) If the sale is successful,
        // make sure a receipt generated and added to the cash register

        // ---

        // Process two customers and afterward print out all receipts
        // and the total income earned

        for (Receipt receipt : store.getCashRegister().getReceipts()) {
            System.out.println(receipt);
        }

        System.out.println(store.getCashRegister().totalEarnings());

        // Extra:
        // 1) Create custom exceptions for certain situations,
        // for example: not enough money in customer wallet
        // 2) Make sure any values of money can not be negative
        // 3) Make use of:
        //      @Override
        //      public String toString() { ... } in all of the classes
    }
}
