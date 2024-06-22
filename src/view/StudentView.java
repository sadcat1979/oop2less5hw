package src.view;

import java.util.List;
import src.controller.Controller;
import src.model.impl.Student;

public class StudentView implements UserView<Student> {

    // Этот Override перенесён с предыдущих уроков и оставлен для совместимости
    @Override
    public void sendOnConsole(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void start() {
        Controller controller = new Controller();
        controller.createStudent("Варгин", "Алексей", "Петрович");
        controller.createStudent("Егоров", "Константин", "Артемович");
        controller.createStudent("Шумилов", "Евгений", "Егорович");
        controller.createStudent("Джохаридзе", "Сергей", "Олегович");
        controller.createTeacher("Иванов", "Алексей", "Порфирьевич");
        controller.createTeacher("Аршинов", "Григорий", "Сергеевич");
        // controller.printAllStudents();
        // controller.printAllTeachers();
        controller.createStudentGroup(1, List.of(1, 3));
        controller.createStudentGroup(2, List.of(2, 4));
        System.out.println("Все группы:");
        controller.printStudentGroups();
        System.out.println("Только группа с id = 2");
        controller.printStudentGroupById(2);
        // в ТЗ написано: функция формирования из Студентов и Преподавателя УчебнойГруппы и возвращения его;
        // "его" это преподавателя видимо. Вывод учителя группы с id 2, поэтому
        System.out.println("Выводим преподавателя группы id = 2:");
        controller.printTeacherByGroupId(2);
    }
}
