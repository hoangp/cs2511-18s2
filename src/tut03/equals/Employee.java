package tut03.equals;

public class Employee {
  private String name;
  private float salary;

  public Employee(String name, float salary) {
    this.name = name;
    this.salary = salary;
  }
  
  public void raiseSalary(double increase) {
    if (increase > 0) { salary += salary * increase / 100; }
  }
  
  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) return true;
    if (otherObject == null) return false; 
    if (getClass() != otherObject.getClass()) return false;
    Employee other = (Employee) otherObject;
    return name.equals(other.name) && salary == other.salary;
  }

  public String getName() { return name; }

  public float getSalary() { return salary; }
}
