package lectures._06.exception;

public class Participant
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public Participant(String name, String phone) throws InputPhoneNotCorrectException {
        if (phone.length() != 8) {
            throw new InputPhoneNotCorrectException();
        }

        this.name = name;
        this.phone = phone;
    }
}
