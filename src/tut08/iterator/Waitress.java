package tut08.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Waitress {
	private List<Menu> menus;

	public Waitress(List<Menu> menus) {
		this.menus = menus;
	}

	private void printAllMenu() {
		for (Menu m : menus) {
			Iterator<?> it = m.getIterator();
			printMenu(it);
			System.out.println();
		}
	}

	private void printMenu(Iterator<?> it) {
		while (it.hasNext()) {
			MenuItem item = (MenuItem) it.next();
			System.out.println(item.toString());
		}
	}

	public static void main(String[] args) {
		List<Menu> menus = new ArrayList<>();
		menus.add(new DinerMenu());
		menus.add(new PancakeHouseMenu());
		menus.add(new CafeMenu());

		Waitress waitress = new Waitress(menus);
		waitress.printAllMenu();
	}
}