package ass2.backend;

public class EmptyTile extends Entity{
	@Override public boolean isStackable() { return true; }
	@Override public boolean isPushable() { return false; }
	@Override public String getSymbol() {	return " . "; }
}
