package Unit8;

/**
 * Functional interface representing a function that formats and displays detailed information about an employee.
 * Implementations of this interface should provide a method to generate a formatted string containing details
 * about the employee, such as name, department.
 */
@FunctionalInterface
public interface EmployeeDisplay {
    /**
     * Formats and displays detailed information about the given employee.
     *
     * @param employee the employee for which detailed information is to be displayed
     * @return a string containing formatted information about the employee
     */
    String print(Employee employee);
}
