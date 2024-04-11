package solutions.database._01.src;


public class TestPasswordHash
{
    public static void main(String[] args) {
        System.out.println(Password.hash("password")); // XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=

        System.out.println(Password.hash("PGR112")); // HRwHBckgE7TRU13p6T6w6yodiip53cJBGSQUiE+dmv4=

        System.out.println(Password.hash("Kristiania")); // oC5w6ThGs630uqAJLqJjPAZLGvBM5jFpYYHCLVecNQ0=
    }
}
