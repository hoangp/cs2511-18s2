package tut07.iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Waitress {
	private List<Menu> menus;

	public Waitress(List<Menu> menus) {
		this.menus = menus;
	}
 
	public void printMenu() {
		// Integrate the iterator code into the waitress class
	
		for (Menu m: menus) {
			Iterator<MenuItem> menuIterator = m.createIterator();
			printMenu(menuIterator);
		}
				
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public static void main(String[] args) {
		Menu dinerMenu = new DinerMenu();
		Menu pancakeMenu = new PancakeHouseMenu();
		Menu cafeMenu = new CafeMenu();
		
		List<Menu> menus = new ArrayList<>();
		menus.add(dinerMenu);
		menus.add(pancakeMenu);
		menus.add(cafeMenu);
		
		Waitress waitress = new Waitress(menus);
		waitress.printMenu();
	}
	
}
