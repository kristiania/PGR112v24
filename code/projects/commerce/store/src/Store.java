package projects.commerce.store.src;

import java.util.ArrayList;

public class Store
{
    //# Fields
    private String name;
    private CashRegister register;

    // Kommenter ut dette feltet om du ønsker en ekstra utfordring:
    // private HashMap<Product, Integer> products
    // Dersom dette gjøres, så må du håndtere hvor mange av hvert
    // produkt butikken har tilgjengelig til salgs og holde denne oppdatert
    // ut ifra salg som gjennomføres - om en vare går tom kan ikke en kunde kjøpe varen!


    //# Constructors
    public Store(String name, Employee employee) {
        this.name = name;
        this.register = new CashRegister(employee);
    }


    //# Getter-methods
    CashRegister getCashRegister() {
        return this.register;
    }
}
