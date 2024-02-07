package lectures._10;


public class Forelesning10 implements Forelesning
{
    @Override
    public String getMainTopic() {
        return "Polymorphism";
    }

    //# Main
    public static void main(String[] args) {
        Forelesning10 lecture = new Forelesning10();

        System.out.println(lecture.getMainTopic());
    }
}
