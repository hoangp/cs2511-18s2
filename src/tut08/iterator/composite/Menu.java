package tut08.iterator.composite;

import java.util.Iterator;

public abstract class Menu implements MenuComponent {
	public abstract Iterator<?> getIterator();

	@Override
	public void print() {
		System.out.println("--" + this.getName());
		Iterator<?> it = this.getIterator();
		while (it.hasNext()) {
			MenuComponent item = (MenuComponent) it.next();
			item.print();
		}
	}
}
