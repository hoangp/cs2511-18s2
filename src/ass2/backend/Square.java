package ass2.backend;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Square {
	private final int row;
	private final int col;
	private final Stack<Entity> entities;
	private Square top;
	private Square bottom;
	private Square left;
	private Square right;
	
	public Square(int row, int col) {
		this.row = row; 
		this.col = col;
		entities = new Stack<>();
		 
		Entity tile = new EmptyTile();
		tile.setSquare(this);
		add(tile);
	}

	/**
	 * Add entity on the top layer
	 */
	public boolean add(Entity entity) {
		if (entity == null) return false;
		if (!isStackable()) return false;
		return entities.add(entity);
	}
	
	/**
	 * @return the entity on top layer
	 */
	public Entity getEntity() {
		if (entities.size() == 0) return null;
		return entities.peek();
	}
	
	/**
	 * Remove the entity on top layer
	 */
	public Entity removeEntity() {
		return entities.pop();
	}
	
	/**
	 * @return if possible to put entity on top of this square
	 */
	public boolean isStackable() {
		if (entities.size() == 0) return true;
		return entities.peek().isStackable();
	}
	
	/**
	 * @return list of 4 adjacent squares
	 */
	public List<Square> getAdjacentSquares() {
		return Arrays.asList(top, bottom, left, right);
	}

	/**
	 * @return if the square is adjacent to this square
	 */
	public boolean isAdjacent(Square square) {
		return getAdjacentSquares().contains(square);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

	public Square getTop() {
		return top;
	}

	public void setTop(Square top) {
		this.top = top;
	}

	public Square getBottom() {
		return bottom;
	}

	public void setBottom(Square bottom) {
		this.bottom = bottom;
	}

	public Square getLeft() {
		return left;
	}

	public void setLeft(Square left) {
		this.left = left;
	}

	public Square getRight() {
		return right;
	}

	public void setRight(Square right) {
		this.right = right;
	}
	
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

	
  public String getSymbol() {
		return getEntity().getSymbol();
  }
	
  @Override
  public String toString() {
		return getSymbol() + "(row=" + row + ",col=" + col + ")";
  }
}
