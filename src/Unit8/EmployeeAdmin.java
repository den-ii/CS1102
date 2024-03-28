package Unit8;

import java.util.*;

/**
 * Employee Admin
 * implements {@link EmployeeDisplay}, {@link EmployeeAllDisplay} functional interface
 * Stores a list of employees, and their departments and helps manage them
 */
public class EmployeeAdmin implements EmployeeDisplay, EmployeeAllDisplay {

   /** stores a list of employees */
    private Collection<Employee> employees = new HashSet<>();

    /** stores a list of departments in the company */
   private final List<String> departments = new ArrayList<>(List.of("Sales", "Human Resources", "Accounting", "Administration",
           "Technology"));

    /** retrieves the list of departments in the company */
    public List<String> getDepartments() {
        return departments;
    }

    /** retrieves the list of employees working in the company */
    public Collection<Employee> getEmployees() {
        return employees;
    }


    /** reads in generated employee data as stores it in a collection */
    public void addEmployeeData(){
       Random random = new Random();
       employees.add(new Employee("Zack Snyder", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Victoria Kelly", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Rodrigo Santino", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Clara Summer", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Deni Ochiche", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Oscar Alarcon", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Leroy Sane", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Jane Sniffel", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Louis Lane", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("John Moore", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));
       employees.add(new Employee("Dave Claim", random.nextInt(35,47), departments.get(random.nextInt(5)),
               random.nextInt(160, 300)));

   }

    /**
     * implements {@code EmployeeDisplay} functional interface, converts an employee data
     * to String
     * @param employee: An Employee
     * @return a String consisting of employee name and department
     * */
    @Override
    public String print(Employee employee) {
        return employee.name() + " - " + employee.department();
    }

    /**
     * implements {@code EmployeeDisplay} functional interface, converts an employee data
     * to String
     * @param employee: An Employee
     * @return a String consisting of employee name, department, age and salary
     * */
    @Override
    public String printAll(Employee employee) {
       return String.format("%s - %s - %d years - $%dk", employee.name(), employee.department(), employee.age(), employee.salary());
    }
}
