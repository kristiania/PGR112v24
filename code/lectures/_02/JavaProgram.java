package lectures._02;

public class JavaProgram
{
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName("Alice");
        student2.setName("Bob");

        System.out.println(student1.getName());
        System.out.println(student2.getName());
    }
}
