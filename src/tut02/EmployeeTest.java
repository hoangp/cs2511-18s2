package tut02;

import java.time.LocalDate;
import java.time.Month;

public class EmployeeTest {

  public static void printStaffDetails(Employee employee) {
    System.out.println(employee.toString());
  }

  public static void main(String[] args) {
    Employee employee = new Employee("Peter", 50);

    LocalDate hireDate = LocalDate.of(2018, Month.JANUARY, 10);
    Manager manager = new Manager("Mary", 100, hireDate);

    printStaffDetails(employee);
    printStaffDetails(manager);
    
    Employee e = new Manager("Bill", 200, hireDate);
    printStaffDetails(e);
  }
}
