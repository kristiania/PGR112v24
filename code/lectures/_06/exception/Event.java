package lectures._06.exception;

import java.util.ArrayList;

public class Event
{
    //# Fields
    private String name;
    private String description;
    private ArrayList<Participant> participants;

    //# Constructor
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.participants = new ArrayList<>();
    }

    //# Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Participant> getParticipants() {
        return this.participants;
    }

    //# Setters
    public void setName(String value) {
        this.name = value;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    //# Methods
    public void addParticipant(Participant object) {
        this.participants.add(object);
    }
}
