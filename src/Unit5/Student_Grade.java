package Unit5;

/**
 * The {@code Student_Grade} class represents the association between a student and their grade.
 * It encapsulates information about a student and their corresponding grade in a course.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Student student = new Student("John Doe", "CU123");
 * Student_Grade studentGrade = new Student_Grade(student);
 * studentGrade.setGrade(85);
 * System.out.println("Grade for " + studentGrade.getStudent().getName() +
 *                    ": " + studentGrade.getGrade());
 * }
 * </pre>
 *
 * <p>This class provides methods to retrieve and set the grade associated with a student.
 *
 * @author Your Name
 * @version 1.0
 */
public class Student_Grade {

    /**
     * The student associated with this grade.
     */
    private Student student;

    /**
     * The grade associated with the student.
     */
    private double grade;

    /**
     * Constructs a new {@code Student_Grade} with the specified student.
     *
     * @param student The student associated with this grade.
     */
    public Student_Grade(Student student) {
        this.student = student;
    }

    /**
     * Constructs a new {@code Student_Grade} with the specified student and specified grade.
     *
     * @param student The student associated with this grade.
     * @param grade The grade associated with the student.
     */
    public Student_Grade(Student student, double grade) {
        this.student = student;
        this.grade = grade;
    }
    /**
     * Returns the grade associated with the student.
     *
     * @return The grade of the student.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Returns the student associated with this grade.
     *
     * @return The student associated with this grade.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the grade associated with the student.
     *
     * @param grade The new grade to be set.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Sets the student associated with this grade.
     *
     * @param student The new student to be associated.
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
