package examples.java.array;

public class TwoDimensionalArray
{
    public static void main(String[] args) {
        int[][] numbers = {
                { 1, 2, 3 },    // [0][0], [0][1], [0][2]
                { 4, 5, 6 },    // [1][0], [1][1], [1][2]
                { 7, 8, 9 }     // [2][0], [2][1], [2][2]
        };

        System.out.printf("Tallet 5: %d%n", numbers[1][1]);
        System.out.printf("Tallet 8: %d%n", numbers[2][1]);

        // ---

        int listsOfNumbers = 0;

        for (int i = 0; i < numbers.length; i ++) {
            listsOfNumbers ++;
        }

        System.out.printf("Antall lister med tall: %d%n", listsOfNumbers);

        // ---

        int numbersTotal = 0;

        for (int[] list : numbers) {
            numbersTotal += list.length;
        }

        System.out.printf("Antall tall totalt: %d%n", numbersTotal);
    }
}
