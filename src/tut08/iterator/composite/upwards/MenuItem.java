package tut08.iterator.composite.upwards;

public class MenuItem implements MenuComponent{
	private String name;
	private String description;
	private boolean vegetarian;
	private double price;

	public MenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public String toString() {
		return (name + ", $" + price + ", " + description);
	}

	@Override
	public void print() {
		System.out.println(this.toString());
	}
}
