package src.model.impl;

import src.model.User;

public class Student extends User {
    private final Integer studentId;

    public Student(Integer studentId, String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }
}
