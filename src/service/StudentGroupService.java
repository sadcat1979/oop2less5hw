package src.service;

import java.util.ArrayList;
import java.util.List;
import src.model.StudentGroup;
import src.model.impl.Student;
import src.model.impl.Teacher;

public class StudentGroupService {

    private final List<StudentGroup> studentGroups = new ArrayList<>();
    private Integer maxGroupId = 0;

    public Integer createStudentGroup(Teacher teacher, List<Student> studentList) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupId(++maxGroupId);
        studentGroup.setTeacher(teacher);
        studentGroup.setStudentList(studentList);
        studentGroups.add(studentGroup);
        return studentGroup.getGroupId();
    }

    public StudentGroup getStudentGroupByGroupId(Integer id) {
        for (StudentGroup group : studentGroups) {
            if (group.getGroupId().equals(id)) {
                return group;
            }
        }
        return null;//throw new Exception("Группа "+id+" не найдена");
    }

    public Teacher getTeacherByGroupId(Integer id) {
        return getStudentGroupByGroupId(id).getTeacher();
    }
    
    public List<StudentGroup> getAllGroups(){
        return studentGroups;
    }
}
