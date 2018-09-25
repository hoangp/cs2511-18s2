package ass2.backend;

public class Boulder extends Entity {
	private final Player player;
	
	public Boulder(Player player) {
		this.player = player;
	}
	
  @Override public boolean isStackable() { return false; }
	@Override public boolean isPushable() { return true; }
	@Override public String getSymbol() { return "[B]"; }
	
  @Override
	public boolean moveAway() {
		if (isAdjacent(player)) {
			if      (player.equals(getTop()))    return moveDown();
			else if (player.equals(getBottom())) return moveUp();
			else if (player.equals(getLeft()))   return moveRight();
			else if (player.equals(getRight()))  return moveLeft();
		}
		return false;
	}
}
