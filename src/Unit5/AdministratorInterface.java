package Unit5;

import java.util.Objects;
import java.util.Scanner;

public class AdministratorInterface {

    /**
     * Administrator Interface
     * main entry to the Program - It runs the administrator interface
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Hello 👋🏽");

        boolean shouldLoop = true;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println(""" 
                     Hit 'a' - add a course, 'e' -  enroll students, 'g' - assign grades,
                     'o' - calculate overall grades, 'v' - view number of students enrolled, and 'x' - exit:""");
            String cmd = scanner.nextLine();

            try {
                shouldLoop = runCmd(cmd);
            } catch (Exception e){
                System.out.println("An error occurred...");
            }

        } while (shouldLoop);
        scanner.close();

    }

    /**
     * Runs different actions for its respective commands on the administrator interface {@code AdministratorInterface}.
     * @param cmd : command from system input to perform actions on the administrator interface.
     * @return true to continue running the administrator interface, otherwise false.
     */
    public static boolean runCmd(String cmd){
        Scanner scanner = new Scanner(System.in);
        return switch (cmd) {
            case "a" -> {
                addCourse(scanner);
                yield true;
            }
            case "e" -> {
                enrollStudent(scanner);
                yield true;
            }
            case "g" -> {
                assignGrade(scanner);
                yield true;
            }
            case "o" -> {
                calculateOverallGrades(scanner);
                yield true;
            }
            case "v" -> {
                System.out.println(Course.getStudentsEnrolled() + " enrolled");
                yield true;
            }
            case "x" -> {
                System.out.println("Logging out...");
                yield false;
            }
            default -> {
                System.out.println("No such command");
                yield true;
            }
        };

    }

    /**
     *  Adds course to the list of courses in {@code CourseManagement}
     * @param scanner : scanner for collecting inputs.
     */
    public static void addCourse(Scanner scanner){
        System.out.println("Enter course name: ");
        String name = scanner.nextLine();
        System.out.println("Enter course code: ");
        String code = scanner.nextLine();
        System.out.println("Enter course capacity: ");
        int capacity = scanner.nextInt();

        if (name.isBlank() || code.isBlank() || capacity <= 0){
               System.out.println("Enter valid values");
               return;
        }
        CourseManagement.addCourse(name, code, capacity);
    }

    /**
     * assign grades to {@code Student}
     * @param scanner : scanner for collecting inputs.
     */
    public static void assignGrade(Scanner scanner){
        System.out.println("Enter Student's ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.println("Enter Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());
        if (ID.isBlank() || courseCode.isBlank()){
            System.out.println("Enter valid values");
            return;
        }
        Student s = Student.getAStudent(ID);
        Course c = CourseManagement.findCourse(courseCode);
        if (s == null){
            System.out.println("No student with this id, enroll student first");
            return;
        }
        if (c == null){
            System.out.println("No Course with that code");
            return;
        }
        CourseManagement.assignGrade(s,  c, grade);

    }

    /**
     * enrolls Student for a course, if {@code Student} is not registered, {@code Student} is generated
     * @param scanner : scanner for collecting inputs.
     */
    public static void enrollStudent(Scanner scanner){
        System.out.println("Is Student registered (y or n): ");
        String cmd = scanner.nextLine();
        Course c = null;
        String id = null;
        String name = null;
        Student s;
        if (cmd.equals("n")) {
            System.out.println("Enter Student's name: ");
            name = scanner.nextLine();
            System.out.println("Enter student's ID: ");
            id = scanner.nextLine();
            if (Student.getAStudent(id) != null){
                System.out.println("Student with that id exists: ");
                return;
            }
            s = new Student(name, id);
            System.out.println("Enter course code: ");
            String courseCode = scanner.nextLine();
             c = CourseManagement.findCourse(courseCode);
        } else if (cmd.equals("y")){
            System.out.println("Enter student's ID: ");
            id = scanner.nextLine();
            if (Student.getAStudent(id) == null){
                System.out.println("No student with that id exists: ");
                return;
            }
            name = Objects.requireNonNull(Student.getAStudent(id)).getName();
            s = Student.getAStudent(id);
            System.out.println("Enter course code: ");
            String courseCode = scanner.nextLine();
            c = CourseManagement.findCourse(courseCode);
        }
        else {
            System.out.println("unknown command");
            return;
        }
        if (c == null){
            System.out.println("No Course with that code");
            return;
        }

        if (name.isBlank() || id.isBlank()) {
            System.out.println("Enter valid values");
            return;
        }
        if (s != null){
            Student.addStudent(s);
            CourseManagement.enrollStudent(s, c);
        }
    }

    /**
     * Calculates the overall grade of a {@code Student} from all the courses enrolled
     * @param scanner
     */
    public static void calculateOverallGrades(Scanner scanner){
        System.out.println("Enter Student ID");
        String id = scanner.nextLine();
        Student s = Student.getAStudent(id);
        if (s == null){
            System.out.println("No student with that id exists: ");
            return;
        }
        System.out.println(s.getName() + " overall grade is " + CourseManagement.calculateOverallGrade(s) + "%");
    }
}
