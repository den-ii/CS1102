package Unit8;

import java.util.*;

/**
 * Employee Management - entry point to program
 * Performs different functions on our employee list and displays the result
 */
public class EmployeeManagement {
    public static void main(String[] args) {
        try {
            EmployeeAdmin admin = new EmployeeAdmin();
            admin.addEmployeeData(); // reads employee data
            Collection<Employee> employeeData = admin.getEmployees();
            System.out.println("Employee Data: " + admin.getEmployees());
            System.out.println("Departments: " + admin.getDepartments());
            System.out.println("-".repeat(50));
            System.out.println("Employees And Their Departments:");
            double streamTime = System.currentTimeMillis();
            employeeData.stream().map(admin::print).forEach(System.out::println);
            System.out.printf("Time: %.2fms\n", (System.currentTimeMillis() - streamTime));
            /* ------------------------------------------------------------------------------------ */
            System.out.println("Average Salary Of Employees:");
            streamTime = System.currentTimeMillis();
            OptionalDouble averageEmployeeSalary = employeeData.stream().mapToDouble(Employee::salary).average();
            System.out.println("$%.2fk".formatted(averageEmployeeSalary.getAsDouble()));
            System.out.printf("Time: %.2fms\n", (System.currentTimeMillis() - streamTime));
            System.out.println("-".repeat(50));
            /* ------------------------------------------------------------------------------------ */
            System.out.println("Employees Over 45 years:");
            employeeData.stream().filter(emp -> emp.age() >= 45).map(admin::printAll).forEach(System.out::println);
            System.out.println("-".repeat(50));
            /* ------------------------------------------------------------------------------------ */
            System.out.println("Extra Features:");
            long employeeCount = employeeData.stream().count();
            System.out.println("Total No Of Employees: " + employeeCount);
            /* ------------------------------------------------------------------------------------ */
            System.out.println("Oldest Employee(s): ");
            employeeData.stream()
                    .sorted(Comparator.comparingDouble(Employee::age).reversed())
                    .filter(emp -> emp.age() == employeeData.stream()
                            .mapToDouble(Employee::age)
                            .max().orElse(0)).map(admin::printAll).forEach(System.out::println);
            /* ------------------------------------------------------------------------------------ --*/
            System.out.println("Highest Earner(s): ");
            employeeData.stream()
                    .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                    .filter(emp -> emp.salary() == employeeData.stream()
                            .mapToDouble(Employee::salary)
                            .max().orElse(0)).map(admin::printAll).forEach(System.out::println);
            /* ------------------------------------------------------------------------------------ */
            DoubleSummaryStatistics stats = employeeData.stream().mapToDouble(Employee::salary).summaryStatistics();
            System.out.printf("Total Salary: $%.2fk%n", stats.getSum());
            System.out.printf("Minimum Salary: $%.2fk%n", stats.getMin());
            System.out.printf("Maximum Salary: $%.2fk%n", stats.getMax());
            System.out.printf("Average Salary: $%.2fk%n", stats.getAverage());
        } catch (Exception e){
            System.out.println("An error occurred: " + e);
        }
    }
}
