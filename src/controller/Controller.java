package src.controller;

import java.util.ArrayList;
import java.util.List;
import src.model.StudentGroup;
import src.model.Type;
import src.model.impl.Student;
import src.model.impl.Teacher;
import src.service.DataService;
import src.service.StudentGroupService;
import src.view.StudentGroupView;
import src.view.StudentView;
import src.view.TeacherView;

public class Controller {

    private final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudentGroupView studentGroupView = new StudentGroupView();

    public Integer createStudent(String lastName, String firstName, String middleName) {
        return dataService.create(Type.STUDENT, lastName, firstName, middleName);
    }

    public Integer createTeacher(String lastName, String firstName, String middleName) {
        return dataService.create(Type.TEACHER, lastName, firstName, middleName);
    }

    public void printAllStudents() {
        studentView.sendOnConsole(dataService.getAllStudents());
    }

    public void printAllTeachers() {
        teacherView.sendOnConsole(dataService.getAllTeachers());
    }

    public Integer createStudentGroup(Integer teacherId, List<Integer> studentIdList) {
        Teacher teacher = (Teacher) dataService.getById(teacherId);
        List<Student> studentList = new ArrayList<>();
        for (Integer id : studentIdList) {
            studentList.add((Student) dataService.getById(id));
        }
        return studentGroupService.createStudentGroup(teacher, studentList);
    }

    public Teacher getTeacherByGroupId(Integer id) {
        return studentGroupService.getTeacherByGroupId(id);
    }

    public void printStudentGroupById(Integer id) {
        studentGroupView.sendOnConsole(studentGroupService.getStudentGroupByGroupId(id));
    }

    public void printStudentGroups() {
        //System.out.println(studentGroupService.getAllGroups());
        //Но раз sout должно быть во View, пришлось городить вот такое
        for (StudentGroup group : studentGroupService.getAllGroups()) {
            printStudentGroupById(group.getGroupId());
        }
    }

    public void printTeacherByGroupId(Integer id) {
        teacherView.printTeacher(studentGroupService.getTeacherByGroupId(id));
    }
}
