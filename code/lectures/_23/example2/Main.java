package lectures._23.example2;

public class Main
{
    public static void main(String[] args) {
        var business = new Business("Bedrift123");

        business.addEmployee();

        business.getEmployees().get(1).printNameOfBusiness();
    }
}
