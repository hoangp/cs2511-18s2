package tut03.equals;

import java.time.LocalDate;

public class Manager extends Employee {
  LocalDate hireDate;

  public Manager(String name, float salary, LocalDate hireDate) {
    super(name, salary);
    this.hireDate = hireDate;
  }

  @Override
  public boolean equals(Object otherObject) {
    if (!super.equals(otherObject)) return false;
    Manager other = (Manager) otherObject;
    return hireDate.equals(other.hireDate);
  }

  @Override
  public String toString() {
    return super.toString() + " hireDate=" + hireDate;
  }

  public LocalDate getHireDate() { return hireDate; }
  
}
