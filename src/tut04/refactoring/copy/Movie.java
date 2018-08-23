package tut04.refactoring.copy;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;
	
	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}
	
	public int getPriceCode() {	return priceCode;	}
	public String getTitle (){ return title; }
	
	public void setPriceCode(int arg) {	priceCode = arg; }

  double getCharge(Rental rental) {
    double thisAmount = 0;
    int priceCode = rental.getMovie().getPriceCode();
  
    switch (priceCode) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (rental.getDaysRented() > 2) thisAmount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (rental.getDaysRented() > 3) thisAmount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return thisAmount;
  }	
}