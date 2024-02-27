package lectures._13.static_block.example1;

public class Main
{
    public static void main(String[] args) {
        Store store1 = new Store();
        Store store2 = new Store();
        Store store3 = new Store();

        System.out.println(store1.catalog.get(7044610874913L).getName());
        System.out.println(store2.catalog.get(7044610874913L).getName());
        System.out.println(store3.catalog.get(7044610874913L).getName());

        store1.catalog.clear();

        try {
            System.out.println(store3.catalog.get(7044610874913L).getName());
        } catch (NullPointerException e) {
            System.out.println("Her får vi en null-pointer exception");
        }

        if (store1.catalog == store2.catalog) {
            System.out.println("Er HashMappet det samme på tvers av objektene? Ja!");
        }
    }
}
