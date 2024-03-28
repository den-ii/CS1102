import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;


/**
 * The Employee class represents an employee with a name, age, department, and salary.
 */
class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    /**
     * Constructs an Employee object with the specified name, age, department, and salary.
     *
     * @param name       the name of the employee
     * @param age        the age of the employee
     * @param department the department of the employee
     * @param salary     the salary of the employee
     */
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the department of the employee.
     *
     * @return the department of the employee
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the age of the employee.
     *
     * @return the age of the employee
     */
    public int getAge() {
        return age;
    }
}

/**
 * The EmployeeProcessing class contains methods to process a list of Employee objects.
 */
public class EmployeeProcessing {

    /**
     * The main method demonstrates various operations on a list of Employee objects.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Omar", 30, "Engineering", 55000),
                new Employee("Hania", 28, "HR", 48000),
                new Employee("Salma", 35, "Finance", 60000),
                new Employee("Ahmed", 32, "Marketing", 58000),
                new Employee("Mohamed", 40, "Engineering", 65000),
                new Employee("Emad", 29, "HR", 50000),
                new Employee("Ali", 33, "Finance", 62000),
                new Employee("Marwa", 31, "Marketing", 57000),
                new Employee("Nancy", 34, "Engineering", 60000),
                new Employee("Reham", 27, "HR", 47000),
                new Employee("Rahma", 36, "Finance", 63000),
                new Employee("Sally", 29, "Marketing", 56000),
                new Employee("Zein", 37, "Engineering", 67000),
                new Employee("Sobhy", 26, "HR", 46000),
                new Employee("Magda", 38, "Finance", 64000)
        );

        // Function to concatenate name and department
        Function<Employee, String> concatNameAndDept = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generating a new collection with concatenated strings using streams
        List<String> concatenatedNamesAndDepts = employees.stream()
                .map(concatNameAndDept)
                .collect(Collectors.toList());

        System.out.println("Concatenated Names and Departments:");
        concatenatedNamesAndDepts.forEach(System.out::println);

        // Finding the average salary of all employees
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("\nAverage Salary of Employees: " + averageSalary);

        // Finding the employee with the highest salary
        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("\nEmployee with the Highest Salary: " + highestPaidEmployee.getName() +
                " - Department: " + highestPaidEmployee.getDepartment() +
                " - Salary: " + highestPaidEmployee.getSalary());

        // Finding the employee with the lowest salary
        Employee lowestPaidEmployee = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Employee with the Lowest Salary: " + lowestPaidEmployee.getName() +
                " - Department: " + lowestPaidEmployee.getDepartment() +
                " - Salary: " + lowestPaidEmployee.getSalary());

        // Finding the oldest employee
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Oldest Employee: " + oldestEmployee.getName() +
                " - Department: " + oldestEmployee.getDepartment() +
                " - Age: " + oldestEmployee.getAge());

        // Filter function to include employees above a certain age threshold
        int ageThreshold = 30;
        List<String> filteredNamesAndDepts = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .map(concatNameAndDept)
                .collect(Collectors.toList());

        System.out.println("\nEmployees Above " + ageThreshold + " Years Old:");
        filteredNamesAndDepts.forEach(System.out::println);
    }
}