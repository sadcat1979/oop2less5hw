package src.model.impl;

import src.model.User;

public class Teacher extends User {

    public Teacher(Integer teacherId, String lastName, String firstName, String middleName) {
        super(teacherId, lastName, firstName, middleName);
    }

    public Integer getTeacherId() {
        return super.getId();
    }

}
