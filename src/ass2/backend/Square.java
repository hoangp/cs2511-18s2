package ass2.backend;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Square {
	private final int row, col; // the location of this square on the board
	private final Stack<Entity> entities; // stack of entities
	private Square above, below, left, right; // reference to adjacent squares
	
	public Square(int row, int col) {
		this.row = row; 
		this.col = col;
		entities = new Stack<>();
		// A square always starts with an empty tile
		Entity tile = new EmptyTile();
		tile.setSquare(this);
		add(tile);
	}

	/**
	 * Add an entity on the top of the entities stack
	 */
	public boolean add(Entity entity) {
		if (entity == null) return false;
		if (!isStackable()) return false;
		return entities.add(entity);
	}
	
	/**
	 * Move the entity on top this square to the other square
	 */
	public boolean moveTo(Square toSquare) {
		if (isAdjacent(toSquare)) {
			if (toSquare.add(getEntity())) {
				return entities.pop() != null;
			} 
		}
		return false;
	}
	
	/**
	 * @return the entity on top of the entities stack
	 */
	public Entity getEntity() {
		if (entities.size() == 0) return null;
		return entities.peek();
	}
	
	/**
	 * @return if possible to put another entity on the entities stack
	 */
	public boolean isStackable() {
		if (entities.size() == 0) return true;
		return entities.peek().isStackable();
	}
	
	/**
	 * @return list of 4 adjacent squares (top, bottom, left, right)
	 */
	public List<Square> getAdjacentSquares() {
		return Arrays.asList(above, below, left, right);
	}

	/**
	 * @return if the square is adjacent to this square
	 */
	public boolean isAdjacent(Square square) {
		return getAdjacentSquares().contains(square);
	}

	/** @return the square above of this square */
	public Square getAboveSquare() { return above; }
	
	/** Update the reference of the above square */
	public void setAboveSquare(Square above) { this.above = above; }

	/** @return the square below of this square */
	public Square getBelowSquare() { return below; }
	
	/** Update the reference of the below square */
	public void setBelowSquare(Square below) { this.below = below; }

	/** @return the square on the left of this square */
	public Square getLeftSquare() { return left; }
	
	/** Update the reference of the square on the left */
	public void setLeftSquare(Square left) { this.left = left; }

	/** @return the square on the right of this square */
	public Square getRightSquare() { return right; }
	
	/** Update the reference of the square on the right */
	public void setRightSquare(Square right) { this.right = right; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Square other = (Square) obj;
		if (col != other.col) return false;
		if (row != other.row) return false;
		return true;
	}

	/** @return the symbol of the entity of top of entities stack */
  public String getSymbol() {
		return getEntity().getSymbol();
  }
	
  @Override
  public String toString() {
		return getSymbol() + "(row=" + row + ",col=" + col + ")";
  }
}
