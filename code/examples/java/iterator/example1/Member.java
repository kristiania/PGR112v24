package examples.java.iterator.example1;

public class Member
{
    //# Fields
    private String name;
    private String role;


    //# Constructors
    public Member(String name, String role) {
        this.setName(name);
        this.setRole(role);
    }


    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }


    //# Setter-methods
    private void setName(String value) {
        this.name = value;
    }

    public void setRole(String value) {
        this.role = value;
    }
}
