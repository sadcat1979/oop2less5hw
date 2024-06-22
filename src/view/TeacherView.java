package src.view;

import java.util.List;
import src.model.impl.Teacher;

public class TeacherView implements UserView<Teacher> {
    @Override
    public void sendOnConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            printTeacher(teacher);
        }
    }

    public void printTeacher(Teacher teacher){
        System.out.println(teacher);
    }
}
