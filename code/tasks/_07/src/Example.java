package tasks._07.src;


public class Example
{
    //# Felter (data)
    private String text;
    private int number;

    //# Konstruktører
    public Example()
    {
        // Bruker setter-metodene for å sette dataen innledningsvis
        this.setText("Årstall");
        this.setNumber(2024);
    }

    //# Getter- og Setter-metoder
    public String getText() {
        return this.text;
    }

    public int getNumber() {
        return this.number;
    }

    public void setText(String value) {
        this.text = value;
    }

    public void setNumber(int value) {
        this.number = value;
    }

    //# Metoder
    public void printData() {
        System.out.println(this.getText() + " " + this.getNumber());
    }

    //# Main-metode
    public static void main(String[] args) {
        Example object = new Example();

        object.printData();

        object.setText("Forelesning");
        object.setNumber(7);

        object.printData();
    }
}
