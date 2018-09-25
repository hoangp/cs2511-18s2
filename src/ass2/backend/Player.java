package ass2.backend;

public class Player extends Entity {
	@Override public boolean isStackable() { return false; }
	@Override public boolean isPusher() { return true; }
	@Override public String getSymbol() { return "[P]"; }
}
