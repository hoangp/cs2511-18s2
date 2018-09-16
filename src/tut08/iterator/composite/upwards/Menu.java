package tut08.iterator.composite.upwards;

import java.util.Iterator;

public abstract class Menu implements MenuComponent {
	private Menu parent;

	public Menu(Menu parent) {
		this.parent = parent;
	}

	public String getParentName() {
		return (parent == null) ? "" : parent.getName() + "--";
	}

	public abstract Iterator<?> getIterator();

	@Override
	public void print() {
		System.out.println("--" + this.getName() + ":");
		Iterator<?> it = this.getIterator();
		while (it.hasNext()) {
			MenuComponent item = (MenuComponent) it.next();
			item.print();
		}
	}
}
