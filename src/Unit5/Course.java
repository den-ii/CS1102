/**
 * The {@code Unit5} package contains classes related to the fifth unit of the course.
 * This package focuses on course management and related functionalities.
 */
package Unit5;

import java.util.ArrayList;

/**
 * The {@code Course} class represents a course in a course management system.
 * It includes information such as the course name, code, maximum capacity, current capacity,
 * and the number of students enrolled.
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * Course javaCourse = new Course("Java Programming", "CS101", 30);
 * javaCourse.incrementCurrentCapacity();
 * javaCourse.incrementStudentEnrolled();
 * }
 * </pre>
 *
 * <p>Keep in mind that this class does not perform extensive error checking related to course capacity,
 * and it's assumed that other components of the system handle such considerations.
 *
 * @author Deni Ochiche
 * @version 1.0
 */
public class Course {

    /**
     * The total number of students enrolled in all instances of the {@code Course} class.
     */
    private static int studentsEnrolled;

    /**
     * The name of the course.
     */
    private String name;

    /**
     * The unique code identifying the course.
     */
    private String code;

    /**
     * The maximum capacity allowed for the course.
     */
    private int maximumCapacity;

    /**
     * The current capacity, representing the number of students currently enrolled.
     */
    private int currentCapacity;

    /**
     * Constructs a new {@code Course} with the specified name, code, and maximum capacity.
     *
     * @param name            The name of the course.
     * @param code            The unique code identifying the course.
     * @param maximumCapacity The maximum capacity allowed for the course.
     */
    public Course(String name, String code, int maximumCapacity) {
        this.name = name;
        this.code = code;
        this.maximumCapacity = maximumCapacity;
    }

    /**
     * Returns the unique code identifying the course.
     *
     * @return The code of the course.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the name of the course.
     *
     * @return The name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the maximum capacity allowed for the course.
     *
     * @return The maximum capacity of the course.
     */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * Returns the total number of students enrolled in all instances of the {@code Course} class.
     *
     * @return The total number of students enrolled.
     */
    public static int getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
     * Increments the total number of students enrolled in all instances of the {@code Course} class.
     */
    public static void incrementStudentEnrolled() {
        studentsEnrolled++;
    }

    /**
     * Returns the current capacity, representing the number of students currently enrolled in the course.
     *
     * @return The current capacity of the course.
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Increments the current capacity, indicating that a student has been enrolled in the course.
     */
    public void incrementCurrentCapacity() {
        this.currentCapacity++;
    }
}
