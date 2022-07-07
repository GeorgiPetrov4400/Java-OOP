package WorkingWithAbstractionLab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void parseCommand(String[] commandsInput) {
        String name = commandsInput[1];
        if (commandsInput[0].equals("Create")) {
            createStudent(commandsInput, name);

        } else if (commandsInput[0].equals("Show")) {
            showStudent(name);
        }
    }

    private void showStudent(String name) {
        if (students.containsKey(name)) {
            Student student = students.get(name);
            StringBuilder output = new StringBuilder(student.toString());
            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }

            System.out.println(output);
        }
    }

    private void createStudent(String[] commandsInput, String name) {
        int age = Integer.parseInt(commandsInput[2]);
        double grade = Double.parseDouble(commandsInput[3]);
        Student student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }
}
