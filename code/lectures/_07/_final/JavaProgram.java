package lectures._07._final;


public final class JavaProgram
{
    public static final String versionNumber = "v1.0.0";

    public final String versionDate;

    public JavaProgram() {
        this.versionDate = "2024-01-30";
    }

    public void printInfo() {
        System.out.println("Java Program information:");
        System.out.println(" - Version number: " + JavaProgram.versionNumber);
        System.out.println(" - Version date: " + this.versionDate);
    }

    public static void printVersion() {
        System.out.println("Java Program version:");
        System.out.println(" - Number: " + JavaProgram.versionNumber);
    }

    public static void main(String[] args) {
        //
    }
}