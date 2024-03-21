package Unit5;

import java.util.ArrayList;

/**
 * The {@code Student} class represents a student in a course management system.
 * It contains information such as the student's name, ID, enrolled courses, and grades.
 * Students can be enrolled in courses and assigned grades.
 *
 * It contains a static list of students to know if a student is registered.
 *
 * <p>This class provides methods to interact with student data, including enrolling
 * in courses, assigning grades, and calculating the overall grade for a student.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Student student = new Student("John Doe", "CU123");
 * student.enrollStudent(new Course("CS101", "Introduction to Computer Science", 30));
 * student.assignGrade(new Course("CS101", "Introduction to Computer Science", 30), 85);
 * double overallGrade = student.calculateOverallGrade();
 * }
 * </pre>
 *
 * @author Your Name
 * @version 1.0
 */
public class Student {
    private String name;
    private String ID;

    /**
     * The list of all registered students.
     */
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * Indicates whether the student is currently enrolled in any course.
     */
    private boolean enrolled = false;

    /**
     * The list of courses and grades associated with the student.
     */
    private ArrayList<Course_Grade> enrolledCourses = new ArrayList<>();

    /**
     * Constructs a new {@code Student} with the specified name and ID.
     *
     * @param name The name of the student.
     * @param ID   The unique ID of the student.
     */
    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    /**
     * Returns the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the list of courses and grades associated with the student.
     *
     * @return The list of enrolled courses and grades.
     */
    public ArrayList<Course_Grade> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Checks if the student is already enrolled in a specific course.
     *
     * @param course The course to be checked.
     * @return true if the student is already enrolled, false otherwise.
     */
    private boolean courseEnrolled(Course course) {
        for (Course_Grade c : enrolledCourses) {
            if (c.getCourse().getName().equals(course.getName()) && c.getCourse().getCode().equals(course.getCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a student based on their ID.
     *
     * @param ID The ID used to retrieve the student.
     * @return The found student or {@code null} if no student with the given ID is found.
     */
    public static Student getAStudent(String ID) {
        for (Student s : students) {
            if (s.getID().equals(ID)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Adds a student to the list of registered students.
     *
     * @param student The student to be added.
     * @return true if the student is successfully registered, false if the student is already registered.
     */
    public static boolean addStudent(Student student) {
        if (getAStudent(student.ID) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    /**
     * Enrolls a student in a course if the course's maximum capacity is not reached.
     *
     * @param course The course to be enrolled in.
     * @return true if the student is successfully enrolled, false otherwise.
     */
    public boolean enrollStudent(Course course) {
        if (courseEnrolled(course)) {
            System.out.println("Student is already registered for this course");
            return false;
        }
        if (course.getCurrentCapacity() < course.getMaximumCapacity()) {
            if (!enrolled) {
                Course.incrementStudentEnrolled();
                enrolled = true;
            }
            course.incrementCurrentCapacity();
            enrolledCourses.add(new Course_Grade(course));
            System.out.println("Student successfully enrolled");
            return true;
        }
        System.out.println("Course currently unavailable");
        return false;
    }

    /**
     * Assigns a grade to a course enrolled by the student.
     *
     * @param course The course to be graded.
     * @param grade  The grade to be assigned.
     * @return true if the grade is successfully assigned, false if the grade or course is not valid.
     */
    public boolean assignGrade(Course course, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Grade is invalid");
            return false;
        }
        for (Course_Grade c : enrolledCourses) {
            if (c.getCourse().getName().equals(course.getName()) && c.getCourse().getCode().equals(course.getCode())) {
                c.setGrade(grade);
                System.out.println("Student has been assigned a grade!");
                return true;
            }
        }
        System.out.println("Student not enrolled for this course, cannot assign grade");
        return false;
    }

    /**
     * Calculates the overall grade for the student based on enrolled courses.
     *
     * @return The calculated overall grade for the student.
     */
    public double calculateOverallGrade() {
        double count = 0;

        for (Course_Grade course : enrolledCourses) {
            count += course.getGrade();
        }

        return count / enrolledCourses.size();
    }
}
