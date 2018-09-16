package tut08.iterator;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu extends Menu {
	private HashMap<String, MenuItem> menuItems = new HashMap<>();

	public CafeMenu() {
		addItem(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
		addItem(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
		addItem(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));
	}

	public void addItem(MenuItem menuItem) {
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	@Override
	public Iterator<?> getIterator() {
		return menuItems.values().iterator();
	}
}