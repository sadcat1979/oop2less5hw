package src.model;

public abstract class User {

    private final Integer id;
    private String lastName;
    private String firstName;
    private String middleName;

    public User(Integer id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": id=%s ФИО = %s %s %s", id, getLastName(), getFirstName(), getMiddleName());
    }

}
