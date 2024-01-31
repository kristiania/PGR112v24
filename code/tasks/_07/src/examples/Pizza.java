package tasks._07.src.examples;


public class Pizza
{
    private final int slices;
    private int taken = 0;

    public Pizza(int slices) {
        this.slices = slices;

        System.out.printf("Created a pizza with %d slices!%n", this.getSlicesTotal());
    }

    public int getSlicesTotal() {
        return this.slices;
    }

    public int getSlicesTaken() {
        return this.taken;
    }

    public int getSlicesLeft() {
        return this.getSlicesTotal() - this.getSlicesTaken();
    }

    public boolean areThereSlicesLeft() {
        return this.taken < this.slices;
    }

    public void takeSlice() {
        if (this.areThereSlicesLeft()) {
            this.taken ++;

            System.out.println("A pizza slice was taken!");
            this.printStatus();
        }
        else {
            System.out.println("There are no pizza slices left to take!");
        }
    }

    public void printStatus() {
        System.out.printf("There are %d slices left!%n", this.getSlicesLeft());
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza(4);

        pizza.takeSlice();
        pizza.takeSlice();
        pizza.takeSlice();
        pizza.takeSlice();

        pizza.takeSlice();
    }
}
