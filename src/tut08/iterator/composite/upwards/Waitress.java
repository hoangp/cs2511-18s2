package tut08.iterator.composite.upwards;

import java.util.ArrayList;
import java.util.List;

public class Waitress {
	private List<Menu> menus;

	public Waitress(List<Menu> menus) {
		this.menus = menus;
	}

	private void printAllMenu() {
		for (Menu m : menus) {
			m.print();
			System.out.println();
		}
	}

	public static void main(String[] args) {
		List<Menu> menus = new ArrayList<>();
		menus.add(new DinerMenu(null));
		menus.add(new PancakeHouseMenu(null));
		menus.add(new CafeMenu(null));

		Waitress waitress = new Waitress(menus);
		waitress.printAllMenu();
	}

}
