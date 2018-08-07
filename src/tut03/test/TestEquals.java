package tut03.test;

import tut03.equals.Employee;
import tut03.equals.Manager;

import java.time.LocalDate;
import java.time.Month;

public class TestEquals {
  public static void main(String[] args) {
    Employee e1 = new Employee("Bill", 50000);  
    Employee e2 = new Employee("Bill", 50000);
    
    System.out.println();
    System.out.println(e1.equals(e2));
    
    // Raise salary of e1
    e1.raiseSalary(10); 
    System.out.println();
    System.out.println("Salary of e1 is increased by 10%. Are e1 and e2 equal?");
    System.out.println(e1.equals(e2));
      
    LocalDate hireDate = LocalDate.of(2018, Month.JANUARY, 10);
    Employee e = new Manager("Bill",50000,hireDate);
    // e.getHireDate() would not compile, but e will be a Manager instance at runtime
    System.out.println();
    System.out.println(e.getClass().getName());
 
    // Testing the equality of a manager and an employee with same name and salary
    System.out.println();
    System.out.println("Manager e and Employee e1 have same name and salary");
    System.out.println(e1.equals(e));
  }
}
