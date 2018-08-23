package tut04.refactoring.copy;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;
	
	public Customer (String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}
	
  public String getName() { return name; }
  public void addRental(Rental rental) { rentals.add(rental); }
 
  public String statement() { 
    double totalAmount = 0;
    String result = "Rental Record for " + getName() + "\n";

    for (Rental r : rentals) {
      result += "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(r.getCharge()) + "\n";
      totalAmount += r.getCharge();
    }

    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    return result;
  }

  public static void main(String[] args) {
    Customer c1 = new Customer("Mary Jane Watson");

    Movie m1 = new Movie("Gone with the wind", Movie.REGULAR);
    Movie m2 = new Movie("Finding Nemo", Movie.CHILDRENS);

    Rental r1 = new Rental(m1, 3);
    Rental r2 = new Rental(m2, 7);

    c1.addRental(r1);
    c1.addRental(r2);

    System.out.println(c1.statement());
  }
}
