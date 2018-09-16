package tut08.iterator.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class DessertMenu extends Menu {
	private ArrayList<MenuComponent> menuItems = new ArrayList<>();

	public DessertMenu() {
		addItem(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla ice cream", true, 1.59));
	}

	public void addItem(MenuComponent menuItem) {
		menuItems.add(menuItem);
	}

	@Override
	public Iterator<?> getIterator() {
		return menuItems.iterator();
	}

	@Override
	public String getName() {
		return "Dessert Menu";
	}
}
