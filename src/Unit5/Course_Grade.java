package Unit5;

/**
 * The {@code Course_Grade} class represents the association between a course and a student's grade.
 * It encapsulates information about a course and the corresponding grade achieved by a student.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Course javaCourse = new Course("Java Programming", "CS101", 30);
 * Course_Grade courseGrade = new Course_Grade(javaCourse);
 * courseGrade.setGrade(85);
 * System.out.println("Grade for " + courseGrade.getCourse().getName() +
 *                    ": " + courseGrade.getGrade());
 * }
 * </pre>
 *
 * <p>This class provides methods to retrieve and set the course and grade associated with a student.
 *
 * @author Your Name
 * @version 1.0
 */
public class Course_Grade {

    /**
     * The course associated with this grade.
     */
    private Course course;

    /**
     * The grade associated with the course.
     */
    private double grade;

    /**
     * Constructs a new {@code Course_Grade} with the specified course.
     *
     * @param course The course associated with this grade.
     */
    public Course_Grade(Course course) {
        this.course = course;
    }

    /**
     * Constructs a new {@code Course_Grade} with the specified course and grade.
     *
     * @param course The course associated with this grade.
     * @param grade  The grade to be associated with the course.
     */
    public Course_Grade(Course course, double grade) {
        this.course = course;
        this.grade = grade;
    }

    /**
     * Returns the course associated with this grade.
     *
     * @return The course associated with this grade.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Returns the grade associated with the course.
     *
     * @return The grade of the course.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the course associated with this grade.
     *
     * @param course The new course to be associated.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Sets the grade associated with the course.
     *
     * @param grade The new grade to be associated.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
