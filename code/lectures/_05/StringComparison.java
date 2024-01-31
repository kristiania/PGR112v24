package lectures._05;

public class StringComparison
{
    public static void main(String[] args) {
        String A = "text";
        String B = "text";
        String C = new String("text");

        if (A == B) {
            System.out.println("funker");
        }

        if (A == C) {
            System.out.println("funker ikke");
        }

        if (A.equals(C)) {
            System.out.println("funker");
        }
    }
}
