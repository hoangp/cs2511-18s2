package ass2.backend;

public class Player extends Entity {
	@Override public boolean isStackable() { return false; }
	@Override public String getSymbol() { return "[P]"; }
	
	/**
	 * Move Player to an entity
	 */
	public boolean moveTo(Entity toEntity) {
		if (super.moveTo(toEntity)) {
			return true;
			
		} else if (toEntity.isPushable()) { // boulder pushing
			Square squareBeforePushed = toEntity.getSquare();
			if (toEntity.pushedBy(this)) {
				return moveToSquare(squareBeforePushed);
			}
		}
		
		return false;
	}
}
