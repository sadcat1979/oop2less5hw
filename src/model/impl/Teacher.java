package src.model.impl;

import src.model.User;

public class Teacher extends User {

    private final Integer teacherId;

    public Teacher(Integer teacherId, String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
        this.teacherId = teacherId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ":id=%s ФИО=%s %s %s", teacherId, getLastName(), getFirstName(), getMiddleName());
    }

}
