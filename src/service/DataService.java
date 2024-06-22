package src.service;

import java.util.ArrayList;
import java.util.List;
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

    // Пришлось так написать из-за задания 1 в презентации
    public Teacher getTeacherById(Integer id) {
        for (User user : userList) {
            if ((user instanceof Teacher) && (((Teacher) user).getTeacherId() == id)) {
                return (Teacher) user;
            }
        }
        return null;//throw new Exception(id+" not found");
    }

    public Student getStudentById(Integer id) {
        for (User user : userList) {
            if ((user instanceof Student) && (((Student) user).getStudentId() == id)) {
                return (Student) user;
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

    // Пришлось так написать из-за задания 1 в презентации
    private Integer getFreeId() {
        Integer maxId = 0;
        Integer userId = 0;
        for (User user : userList) {
            if (user instanceof Teacher) {
                userId = ((Teacher) user).getTeacherId();
            }
            if (user instanceof Student) {
                userId = ((Student) user).getStudentId();
            }
            if (userId > maxId) {
                maxId = userId;
            }
        }
        return maxId + 1;
        //     Integer maxId = 0;
        //     for (User user : userList) {
        //         if (user.getId() > maxId) {
        //             maxId = user.getId();
        //         }
        //     }
        //     return maxId + 1;
    }
}
