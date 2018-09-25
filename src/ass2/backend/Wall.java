package ass2.backend;

public class Wall extends Entity{
	@Override public boolean isStackable() { return false; }
	@Override public boolean isPushable() { return false; }
	@Override public String getSymbol() { return "[X]"; }
}
