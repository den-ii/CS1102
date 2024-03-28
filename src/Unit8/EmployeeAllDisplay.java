package Unit8;

/**
 * Functional interface representing a function that formats and displays detailed information about an employee.
 * Implementations of this interface should provide a method to generate a formatted string containing various details
 * about the employee, such as name, department, salary, etc.
 */
@FunctionalInterface
public interface EmployeeAllDisplay {
    /**
     * Formats and displays detailed information about the given employee.
     *
     * @param employee the employee for which detailed information is to be displayed
     * @return a string containing formatted information about the employee
     */
    String printAll(Employee employee);
}
