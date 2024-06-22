package src.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import src.model.Type;
import src.model.User;
import src.model.impl.Student;
import src.model.impl.Teacher;

public class DataService {

    //не уверен правильно ли понял ТЗ, сделал общую "базу", объекты различаются по InstanceOf,
    //в теории студент может доучиться до преподавателя
    private static final List<User> userList = new ArrayList<>();
    //а должна ли быть БД public? никто ж не мешает new DataService().getAllUsers()

    public Integer create(Type type, String lastName, String firstName, String middleName) {
        Integer id = getFreeId();
        if (type == Type.STUDENT) {
            Student student = new Student(id, lastName, firstName, middleName);
            userList.add(student);
        }
        if (type == Type.TEACHER) {
            Teacher teacher = new Teacher(id, lastName, firstName, middleName);
            userList.add(teacher);
        }
        return id;
    }

    public User getById(Integer id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;//throw new Exception(id+" not found");
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teachers.add((Teacher) user);
            }
        }
        return teachers;
    }

    private Integer getFreeId() {
        Integer maxId = 0;
        for (User user : userList) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        return maxId + 1;
    }
}