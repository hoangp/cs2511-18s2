package ass2.backend;

public class Switch extends Entity{
	@Override public boolean isStackable() { return true; }
	@Override public String getSymbol() { return "[S]"; }
	@Override public boolean isTriggerable() { return true; }
	
	private boolean triggered = false;
	public boolean isTriggered() { return triggered; }
	@Override public void setTrigger(boolean triggered) {this.triggered = triggered; }
}
