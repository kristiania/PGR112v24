package examples.java.iterator.example1;

public class JavaProgram
{
    public static void main(String[] args) {
        Group group = new Group();

        Member member1 = new Member("Marcus", "Healer");
        Member member2 = new Member("Alexander", "Tank");

        group.addMember(member1);
        group.addMember(member2);

        System.out.println("Group members:");

        // Legg merke til at vi looper igjennom objektet direkte
        for (Member member : group) {
            System.out.printf("- Name: %s | Role: %s%n".formatted(
                    member.getName(),
                    member.getRole()
            ));
        }
    }
}
