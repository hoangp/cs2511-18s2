package tut08.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class DinerMenu extends Menu {
	private static final int MAX_ITEMS = 10;
	private int numberOfItems = 0;
	private MenuItem[] menuItems = new MenuItem[MAX_ITEMS];

	public DinerMenu() {
		addItem(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
		addItem(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
		addItem(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29));
		addItem(new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
		addItem(new MenuItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99));
		addItem(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));
	}

	public void addItem(MenuItem menuItem) {
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full!  Can't add item to menu");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	@Override
	public Iterator<?> getIterator() {
		return Arrays.asList(Arrays.copyOfRange(menuItems, 0, numberOfItems)).iterator();
	}
}
