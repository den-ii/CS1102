package Unit8;

import java.util.*;

public class EmployeeAdmin implements EmployeeDisplay, EmployeeAllDisplay {
   private Collection<Employee> employees = new HashSet<>();
   private final List<String> departments = new ArrayList<>(List.of("Sales", "Human Resources", "Accounting", "Administration",
           "Technology"));


    public List<String> getDepartments() {
        return departments;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }



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

    @Override
    public String print(Employee employee) {
        return employee.name() + " - " + employee.department();
    }

    @Override
    public String printAll(Employee employee) {
       return String.format("%s - %s - %d years - $%dk", employee.name(), employee.department(), employee.age(), employee.salary());
    }
}
