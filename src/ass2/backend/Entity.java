package ass2.backend;

public abstract class Entity {
	private Square square; // the current square of this entity
	
	/**
	 * @return if possible to put any entity on top of this entity
	 */
	public abstract boolean isStackable();
	
	/**
	 * @return if possible to push this entity
	 */
	public abstract boolean isPushable();
	
	/**
	 * @return the symbol presentation of this entity
	 */
	public abstract String getSymbol();
	
	/**
	 * @return the square of this entity
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * Set the current square of this entity
	 */
	public void setSquare(Square square) {
		this.square = square;
	}
	
	/**
	 * Move this entity to toSquare
	 */
	public boolean moveTo(Square toSquare) {
		if (square.isAdjacent(toSquare)) {
			if (toSquare.add(this)) {
				square.removeEntity();
				square = toSquare;
				return true;
			} 
		}
		return false;
	}
	
	public boolean moveTo(Entity entity) {
		if (entity == null) return false;
		if (moveTo(entity.getSquare())) return true;
		else if (entity.isPushable()) {
			Square toSquare = entity.getSquare();
			if (entity.moveAway()) {
				return moveTo(toSquare);
			}
		}
		return false;
	}
	
	public boolean moveAway() {
		return false;
	}
	
	public boolean isAdjacent(Entity entity) {
		return square.isAdjacent(entity.getSquare());
	}
	
	public Entity getTop() {
		Square squareTop = square.getTop();
		return (squareTop == null) ? null : squareTop.getEntity();
	}
	
	public Entity getBottom() {
		Square squareBottom = square.getBottom();
		return (squareBottom == null) ? null : squareBottom.getEntity();
	}
	
	public Entity getLeft() {
		Square squareLeft = square.getLeft();
		return (squareLeft == null) ? null : squareLeft.getEntity();
	}
	
	public Entity getRight() {
		Square squareRight = square.getRight();
		return (squareRight == null) ? null : squareRight.getEntity();
	}
	
	public boolean moveUp() {
		return moveTo(getTop());
	}
	
	public boolean moveDown() {
		return moveTo(getBottom());
	}
	
	public boolean moveLeft() {
		return moveTo(getLeft());
	}
	
	public boolean moveRight() {
		return moveTo(getRight());
	}
}
