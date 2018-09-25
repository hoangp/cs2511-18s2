package ass2.backend;

public class Boulder extends Entity {	
  @Override public boolean isStackable() { return false; }
	@Override public boolean isPushable() { return true; }
	@Override public String getSymbol() { return "[B]"; }
	
  @Override
	public boolean pushedBy(Entity pusher) {
		if (isAdjacent(pusher)) {
			if      (pusher.equals(getAboveEntity()))    return moveDown();
			else if (pusher.equals(getBelowEntity())) return moveUp();
			else if (pusher.equals(getLeftEntity()))   return moveRight();
			else if (pusher.equals(getRightEntity()))  return moveLeft();
		}
		return false;
	}
}
