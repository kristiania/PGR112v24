package solutions._07.example3;

public class Person
{
    private String name = "Ukjent";
    private Watch watch = null;

    public String getName() {
        return this.name;
    }

    public Watch getWatch() {
        return this.watch;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setWatch(Watch value) {
        this.watch = value;
    }

    public void askWhatTheTimeIs() {
        if (this.getWatch() == null) {
            System.out.println("Sorry, I don't have a watch!");
        }
        else {
            System.out.println("The time is currently %s".formatted(this.getWatch().getCurrentTime()));
        }
    }
}
