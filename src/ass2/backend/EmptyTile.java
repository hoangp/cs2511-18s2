package ass2.backend;

public class EmptyTile extends Entity{
	@Override public boolean isStackable() { return true; }
	@Override public String getSymbol() {	return " . "; }
}
