package tut08.iterator.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class DessertMenu extends Menu {
	private ArrayList<MenuItem> menuItems;

	public DessertMenu() {
		menuItems = new ArrayList<MenuItem>();
		addItem(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla ice cream", true, 1.59));
	}

	public void addItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	@Override
	public Iterator<?> getIterator() {
		return menuItems.iterator();
	}
}
