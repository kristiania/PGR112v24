package solutions._04;

import java.util.ArrayList;

public class Terminal
{
    private ArrayList<String> options;

    void addOption(String value) {
        this.options.add(value);
    }

    void clearOptions() {
        this.options.clear();
    }

    void displayMenu() {
        System.out.println("Terminalmeny:");

        for (int i = 0; i < this.options.size(); i ++) {
            System.out.println("- " + (i + 1) + ") " + this.options.get(i));
        }
    }
}
