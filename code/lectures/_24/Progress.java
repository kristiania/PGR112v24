package lectures._24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Progress
{
    //# Main-method
    public static void main(String[] args) {
        var progress = new Progress("files/private/PROGRESS.md");

        System.out.println("---");

        System.out.println(STR."Antall temaer: \{progress.topics.size()}");
        System.out.println(STR."Siste sjekkliste-linje fra første tema: \{progress.topics.getFirst().items.getLast().name}");

        System.out.println("---");

        //System.out.println(STR."\{progress.topics.get(1).subTopics.get(0).items.get(0).name}");

        for (var topic : progress.topics) {
            System.out.println("--- TEMA START ---");
            System.out.println(STR."Tema: \{topic.name}");

            for (var checklist : topic.items) {
                System.out.println(checklist);
            }

            for (var subTopic : topic.subTopics) {
                System.out.println(STR."# Sub-tema: \{subTopic.name}");

                for (var checklist : subTopic.items) {
                    System.out.print("---");
                    System.out.println(checklist);
                }
            }

            System.out.println("--- TEMA SLUTT ---");
        }
    }

    //# Fields
    ArrayList<Topic> topics = new ArrayList<>();

    //# Constructors
    Progress(String filePath) {
        var file = new File(filePath);

        if (file.exists() && file.isFile()) {
            System.out.println(STR."Parsing the following file: \"\{filePath}\" ...");

            this.parse(file);
        }
        else {
            throw new RuntimeException("Could not locate file to parse!");
        }
    }

    void parse(File file) {
        try (var input = new Scanner(file)) {
            String line;
            boolean topic = false;
            boolean topicSub = false;

            while (input.hasNextLine()) {
                line = input.nextLine();

                if (!topic) {
                    if (line.startsWith("> Tema: ")) {
                        topic = true;

                        this.topics.add(new Topic(line.substring(8)));
                    }
                }
                else {
                    if (line.equals("---")) {
                        topic = topicSub = false;

                    }
                    else {
                        if (line.startsWith("| ")) {
                            topicSub = true;

                            this.topics.getLast().addSubTopic(line.substring(2));
                        }
                        else {
                            if (line.startsWith("- [")) {
                                String name = line.substring(6);
                                boolean status = line.substring(5, 6).equalsIgnoreCase("x");

                                if (!topicSub) {
                                    this.topics.getLast().addCheckList(name, status);
                                }
                                else {
                                    this.topics.getLast().subTopics.getLast().addCheckList(name, status);
                                }
                            }
                        }
                    }
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Parsing complete!");
    }

    static class Topic
    {
        //# Fields
        String name;
        ArrayList<Topic.CheckList> items = new ArrayList<>();
        ArrayList<Topic> subTopics = new ArrayList<>();


        //# Constructors
        Topic(String name) {
            this.name = name;
        }


        //# Methods
        Topic.CheckList addCheckList(String name, boolean status) {
            var checkList = this.new CheckList(name, status);

            this.items.add(checkList);

            return checkList;
        }

        Topic addSubTopic(String name) {
            var subTopic = new Topic(name);

            this.subTopics.add(subTopic);

            return subTopic;
        }

        class CheckList {
            String name;
            boolean status;

            private CheckList(String name, boolean status) {
                this.name = name;
                this.status = status;
            }

            Topic getTopic() {
                return Topic.this;
            }

            public String toString() {
                return STR."- [\{this.status ? "X" : " "}] \{this.name}";
            }
        }
    }
}
