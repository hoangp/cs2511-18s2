package tut08.composite.good;

public abstract class BicycleComponent {
	private float cost;

	public BicycleComponent(float cost) {
		this.cost = cost;
	}

	public float getCost() { return cost; }
	public void setCost(float cost) { this.cost = cost; }

	public abstract float getWeight();

	// Unimplemented Method
	public void addComponent(BicycleComponent c) {}
	public void removeComponent(BicycleComponent c) {}
	public BicycleComponent getChild(int i) {return null;}
}
