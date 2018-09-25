package ass2.backend;

public class Boulder extends Entity {	
  @Override public boolean isStackable() { return false; }
	@Override public boolean isPushable() { return true; }
	@Override public String getSymbol() { return "[B]"; }
	
  @Override
	public boolean pushedBy(Entity pusher) {
		if (isAdjacent(pusher)) {
			if      (pusher.equals(getAboveEntity())) 
//				Square thisSquare = getSquare();
//				Square belowSquare = thisSquare.getBelowSquare();
//				if (moveDown()) {
//					Entity 
//					if (thisSquare.getEntity().isTriggerable()) thisSquare.get
//					if (below.isTriggerable());
//					
//				}
//			}
				return moveDown();
			else if (pusher.equals(getBelowEntity())) return moveUp();
			else if (pusher.equals(getLeftEntity()))  return moveRight();
			else if (pusher.equals(getRightEntity())) return moveLeft();
		}
		return false;
	}
}
