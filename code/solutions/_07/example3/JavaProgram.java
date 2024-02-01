package solutions._07.example3;

public class JavaProgram
{
    public static void main(String[] args) {
        Person person = new Person();
        Watch watch = new Watch();

        person.askWhatTheTimeIs();

        person.setWatch(watch);

        person.askWhatTheTimeIs();
    }
}
