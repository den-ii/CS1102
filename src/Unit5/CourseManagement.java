package Unit5;

import java.util.ArrayList;

/**
 * The {@code CourseManagement} class is responsible for managing courses, student enrollments,
 * and overall course grades within the course management system.
 *
 * <p>It provides functionalities to add courses, find courses, enroll students in courses,
 * assign grades to students, and calculate overall grades for individual students.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * CourseManagement.addCourse("Java Programming", "CS101", 30);
 * CourseManagement.enrollStudent(student, javaCourse);
 * CourseManagement.assignGrade(student, javaCourse, 85);
 * double overallGrade = CourseManagement.calculateOverallGrade(student);
 * }
 * </pre>
 *
 * <p>Keep in mind that this class does not perform extensive error checking related to course existence
 * or other considerations, and it's assumed that other components of the system handle such validations.
 *
 * @author Your Name
 * @version 1.0
 */
public class CourseManagement {

    /**
     * The list of courses managed by the {@code CourseManagement} system.
     */
    private static ArrayList<Course> courses = new ArrayList<>();

    /**
     * The list of overall course grades for individual students.
     */
    private static ArrayList<Student_Grade> overallStudentCourseGrade = new ArrayList<>();

    /**
     * Returns the list of courses managed by the {@code CourseManagement} system.
     *
     * @return The list of courses.
     */
    public static ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Returns the list of overall course grades for individual students.
     *
     * @return The list of overall course grades.
     */
    public static ArrayList<Student_Grade> getOverallStudentCourseGrade() {
        return overallStudentCourseGrade;
    }



    /**
     * Adds a new course to the course management system.
     *
     * @param name            The name of the new course.
     * @param code            The unique code identifying the new course.
     * @param maximumCapacity The maximum capacity of the new course.
     */
    public static void addCourse(String name, String code, int maximumCapacity) {
        Course course = new Course(name, code, maximumCapacity);
        if (!validCourse(course)) {
            courses.add(course);
            System.out.println("Course added successfully!");
            return;
        }
        System.out.println("Course already in the system");
    }

    /**
     * Finds and returns a course based on its unique code.
     *
     * @param courseCode The unique code identifying the course.
     * @return The found course or {@code null} if no such course is found.
     */
    public static Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    private static boolean validCourse(Course course) {
        for (Course c : courses) {
            if (c.getName().equals(course.getName()) && c.getCode().equals(course.getCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Enrolls a student in a course.
     *
     * @param student The student to be enrolled.
     * @param course  The course in which the student will be enrolled.
     */
    public static void enrollStudent(Student student, Course course) {
        if (validCourse(course)) {
            student.enrollStudent(course);
        } else {
            System.out.println("No such course available");
        }
    }

    /**
     * Assigns a grade to a student for a specific course.
     *
     * @param student The student to whom the grade will be assigned.
     * @param course  The course for which the grade will be assigned.
     * @param grade   The grade to be assigned.
     */
    public static void assignGrade(Student student, Course course, double grade) {
        if (validCourse(course)) {
            student.assignGrade(course, grade);
        } else {
            System.out.println("No such course available");
        }
    }

    /**
     * Calculates the overall grade for a student based on enrolled courses, and updates the lost for student's overall grade..
     *
     * @param student The student for whom the overall grade will be calculated.
     * @return The calculated overall grade for the student.
     */
    public static double calculateOverallGrade(Student student) {
        ArrayList<Course_Grade> allCourses = student.getEnrolledCourses();
        double count = 0;
        double overallGrade = 0;

        for (Course_Grade course : allCourses) {
            count += course.getGrade();
        }

        overallGrade = count / courses.size();

        for (Student_Grade sg:  overallStudentCourseGrade){
            if (student.getID().equals(sg.getStudent().getID())){
                sg.setGrade(overallGrade);
                return overallGrade;
            }
        }
        Student_Grade sg = new Student_Grade(student, overallGrade);
        overallStudentCourseGrade.add(sg);
        return overallGrade;

    }
}
