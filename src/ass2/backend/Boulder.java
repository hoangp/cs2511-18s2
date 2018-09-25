package ass2.backend;

public class Boulder extends Entity {	
  @Override public boolean isStackable() { return false; }
	@Override public String getSymbol() { return "[B]"; }
	
	@Override public boolean isPushable() { return true; }

  @Override
	public boolean pushedBy(Entity pusher) {
  	boolean pushSuccess = false;
  	Square fromSquare = getSquare();
  	Entity targetEntity = null;
		if (isAdjacent(pusher)) {
			if (pusher.equals(getAboveEntity())) {
				targetEntity = getBelowEntity();
				pushSuccess = moveDown();
			} else if (pusher.equals(getBelowEntity())) {
				targetEntity = getAboveEntity();
				pushSuccess = moveUp();
			} else if (pusher.equals(getLeftEntity()))  {
				targetEntity = getRightEntity();
				pushSuccess = moveRight();
			} else if (pusher.equals(getRightEntity())) {
				targetEntity = getLeftEntity();
				pushSuccess = moveLeft();
			};
		}
		
		if (pushSuccess) {
			if (targetEntity.isTriggerable()) targetEntity.setTrigger(true);
			Entity hiddenEntity = fromSquare.getEntity();
			if (hiddenEntity.isTriggerable()) hiddenEntity.setTrigger(false);
		}
		
		return pushSuccess;
	}
}
