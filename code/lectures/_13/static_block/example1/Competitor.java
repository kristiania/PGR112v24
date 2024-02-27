package lectures._13.static_block.example1;

import examples.data.Product;

public class Competitor
{
    public static void main(String[] args) {
        Store neighbourStore = new Store();

        Product dangerousProduct = new Product(1231231231L, "Brennbart materiale", 1);

        // Vi ønsker ikke at andre klasser enkelt skal kunne endre produkter!
        // neighbourStore.getProducts().put(dangerousProduct.getCode(), dangerousProduct);

    }
}
