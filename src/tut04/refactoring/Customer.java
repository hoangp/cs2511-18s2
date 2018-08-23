package tut04.refactoring;

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
      double thisAmount = 0;
      int priceCode = r.getMovie().getPriceCode();

      switch (priceCode) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (r.getDaysRented() > 2) thisAmount += (r.getDaysRented() - 2) * 1.5;
          break;
        case Movie.NEW_RELEASE:
          thisAmount += r.getDaysRented() * 3;
          break;
        case Movie.CHILDRENS:
          thisAmount += 1.5;
          if (r.getDaysRented() > 3) thisAmount += (r.getDaysRented() - 3) * 1.5;
          break;
      }
      
      result += "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
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
