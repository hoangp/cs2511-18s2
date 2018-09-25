package ass2.backend;

public class Boulder extends Entity {	
  @Override public boolean isStackable() { return false; }
	@Override public boolean isPushable() { return true; }
	@Override public String getSymbol() { return "[B]"; }
	
  @Override
	public boolean pushedBy(Entity pusher) {
		if (isAdjacent(pusher)) {
			if      (pusher.equals(getTop()))    return moveDown();
			else if (pusher.equals(getBottom())) return moveUp();
			else if (pusher.equals(getLeft()))   return moveRight();
			else if (pusher.equals(getRight()))  return moveLeft();
		}
		return false;
	}
}
