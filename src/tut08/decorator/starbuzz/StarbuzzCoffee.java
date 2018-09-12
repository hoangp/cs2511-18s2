package tut08.decorator.starbuzz;

import java.util.List;
import java.util.ArrayList;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		List<Beverage> coffees = new ArrayList<>();
		coffees.add(new Espresso());
		coffees.add(new Whip(new Mocha(new Mocha(new DarkRoast()))));
		coffees.add(new Whip(new Mocha(new Soy(new HouseBlend()))));
		
		for (Beverage c : coffees)
			System.out.println(c.getDescription() + " $" + c.cost());
	}
}
