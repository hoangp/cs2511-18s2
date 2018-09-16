package tut08.iterator.composite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu extends Menu {
	private HashMap<String, MenuComponent> menuItems = new HashMap<>();

	public CafeMenu() {
		addItem(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
		addItem(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
		addItem(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));
		
		addItem(new DessertMenu());
	}
  
	public void addItem(MenuComponent menuItem) {
		menuItems.put(menuItem.toString(),menuItem);
	}

	public Map<String, MenuComponent> getItems() {
		return menuItems;
	}

	@Override
	public Iterator<?> getIterator() {
		return menuItems.values().iterator();
	}

	@Override
	public String getName() {
		return "Cafe Menu";
	}
}