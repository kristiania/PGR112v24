package lectures._03;

import java.util.Random;

public class Coin
{
    //# Fields
    private String type;
    private int value = 0;
    private int amount = 0;

    //# Constructor
    Coin(String type) {
        switch(type) {
            case "gold":
                this.value = 1_00_00;
                break;

            case "silver":
                this.value = 1_00;
            break;

            case "bronze":
                this.value = 10;
            break;

            case "copper":
                this.value = 1;
        }

        this.type = type;
    }

    //# Getters and Setters
    public String getType() {
        return this.type;
    }

    public int getValue() {
        return this.value*this.getAmount();
    }

    public int getAmount() {
        return this.amount;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setAmount(int value) {
        this.amount = value;
    }

    public int flipCoinForTypeValue() {
        if (Coin.flip()) {
            return this.getValue();
        }
        else {
            return 0;
        }
    }

    //# Method
    public static boolean flip() {
        Random rng = new Random();

        return rng.nextInt(2) == 1;
    }
}
