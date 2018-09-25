package ass2.backend;

public class Switch extends Entity{
	@Override public boolean isStackable() { return true; }
	@Override public boolean isPushable() { return false; }
	@Override public String getSymbol() { return "[S]"; }
	
	private boolean triggered = false;
	@Override public boolean isTriggerable() {return true; }
	@Override public boolean isTriggered() {return triggered; }
	@Override public void setTrigger(boolean triggered) {this.triggered = triggered; }
}
