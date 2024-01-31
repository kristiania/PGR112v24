package solutions._06;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// Oppgave 3
public class AskQuestionsSaveAnswers
{
    public static void main(String[] args) {
        ArrayList<String> questions = new ArrayList<>();

        questions.add("Hva er navnet ditt?");
        questions.add("Hva er alderen din?");

        ArrayList<String> answers = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        for (String question : questions) {
            System.out.printf("%s ", question);

            answers.add(input.nextLine());
        }

        try {
            FileWriter output = new FileWriter("files/tasks/06/answers.txt");

            for (int i = 0; i < answers.size(); i ++) {
                output.write("Q: %s%n".formatted(questions.get(i)));
                output.write("A: %s%n".formatted(answers.get(i)));
            }

            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

