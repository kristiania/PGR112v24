package tasks._07.src.examples;

public class ContactCard
{
    private String name;
    private final String email;
    private final long phone;

    public ContactCard(String name, String email, long phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhoneNumber() {
        return this.phone;
    }
}