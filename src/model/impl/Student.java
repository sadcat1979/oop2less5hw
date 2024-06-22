package src.model.impl;

import src.model.User;

public class Student extends User {

    public Student(Integer studentId, String lastName, String firstName, String middleName) {
        super(studentId, lastName, firstName, middleName);
    }

    public Integer getStudentId() {
        return super.getId();
    }
}
