package ass2.backend;

public abstract class Entity {
	private Square square; // the current square of this entity
	
	/** @return the string symbol presentation of this entity */
	public abstract String getSymbol();
	
	/** @return true if possible to put any entity on top of this entity */
	public abstract boolean isStackable();
	
	/** @return true if possible to push this entity (Boulder) */
	public boolean isPushable() { return false; };
	
	/** @return true if this entity has power to push things  */
	public boolean isPusher() { return false; };
	
	/** the behavior when this entity is pushed by the pusher */
	public boolean pushedBy(Entity pusher) { 
		if (isPushable()) throw new RuntimeException("Must be Override");
		return false; 
	}
	
	/** @return true if possible to trigger this entity (Switch) */
	public boolean isTriggerable() { return false; };
	
	/** @return true if the entity is triggered */
	public boolean isTriggered() { return false; };
	
	/** Set the trigger status (only if this entity is trigger-able) */
	public void setTrigger(boolean triggered) {
		if (isTriggerable()) throw new RuntimeException("Must be Override");
	};
	
	/** @return the square that this entity located */
	public Square getSquare() { return square; }
	
	/** Set the current square of this entity */
	public void setSquare(Square square) { this.square = square; }
	
	/** 
	 * @return true if this entity is adjacent to other entity 
	 */
	public boolean isAdjacent(Entity other) {
		return square.isAdjacent(other.getSquare());
	}
	
	/**
	 * Move this entity to a square
	 */
	private boolean moveToSquare(Square toSquare) {
		if (square.moveTo(toSquare)) {
			square = toSquare;
			return true;
		}
		return false;
	}
	
	/**
	 * Move this entity to an entity
	 */
	private boolean moveTo(Entity toEntity) {
		if (toEntity == null) return false; // check null entity (out of boundary)
		
		if (toEntity.isStackable())
		  return moveToSquare(toEntity.getSquare());
		  
		else if (toEntity.isPushable() && this.isPusher()) { // boulder pushing
			Square squareBeforePushed = toEntity.getSquare();
			if (toEntity.pushedBy(this)) {
				return moveToSquare(squareBeforePushed);
			}
		}
		return false;
	}
	
	/** Move this entity up */
	public boolean moveUp() { return moveTo(getAboveEntity()); }
	
	/** Move this entity down */
	public boolean moveDown() { return moveTo(getBelowEntity()); }
	
	/** Move this entity to the left */
	public boolean moveLeft() { return moveTo(getLeftEntity()); }
	
	/** Move this entity to the right */
	public boolean moveRight() { return moveTo(getRightEntity()); }
	
	/**
	 * @return the entity on the square above of this entity's square
	 */
	public Entity getAboveEntity() {
		Square above = square.getAboveSquare();
		return (above == null) ? null : above.getEntity();
	}
	
	/**
	 * @return the entity on the square below of this entity's square
	 */
	public Entity getBelowEntity() {
		Square below = square.getBelowSquare();
		return (below == null) ? null : below.getEntity();
	}
	
	/**
	 * @return the entity on the square on the left of this entity's square
	 */
	public Entity getLeftEntity() {
		Square left = square.getLeftSquare();
		return (left == null) ? null : left.getEntity();
	}
	
	/**
	 * @return the entity on the square on the right of this entity's square
	 */
	public Entity getRightEntity() {
		Square right = square.getRightSquare();
		return (right == null) ? null : right.getEntity();
	}
}
