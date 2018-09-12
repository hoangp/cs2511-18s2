package tut08.iterator.composite;

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
		menus.add(new DinerMenu());
		menus.add(new PancakeHouseMenu());
		menus.add(new CafeMenu());

		Waitress waitress = new Waitress(menus);
		waitress.printAllMenu();
	}

}
