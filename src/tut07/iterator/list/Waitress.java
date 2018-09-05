package tut07.iterator.list;
import java.util.ArrayList;
import java.util.List;

public class Waitress {
	private List<Menu> menus;

	public Waitress(List<Menu> menus) {
		this.menus = menus;
	}
 
	public void printMenu() {
		// Integrate the iterator code into the waitress class
	
		for (Menu m: menus) {
			//Iterator<MenuItem> menuIterator = m.createIterator();
			printMenu(m);
		}
				
	}

//	private void printMenu(Iterator<MenuItem> iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = iterator.next();
//			System.out.print(menuItem.getName() + ", ");
//			System.out.print(menuItem.getPrice() + " -- ");
//			System.out.println(menuItem.getDescription());
//		}
//	}
	
	// Waitress class
	private void printMenu(Menu menu) {
	  for (MenuItem menuItem :menu.getMenuItems() ) {
	    System.out.print(menuItem.toString());
	  }
  }
	
	
	
	public static void main(String[] args) {
		List<Menu> menus = new ArrayList<>();
		menus.add(new DinerMenu());
		menus.add(new PancakeHouseMenu());
		menus.add(new CafeMenu());
		
		Waitress waitress = new Waitress(menus);
		waitress.printMenu();
	}
	
}
