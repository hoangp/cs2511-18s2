package tut08.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu extends Menu {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();;

	public PancakeHouseMenu() {
		addItem(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
		addItem(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
		addItem(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49));
		addItem(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));
	}

	public void addItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	@Override
	public Iterator<?> getIterator() {
		return menuItems.iterator();
	}
}
