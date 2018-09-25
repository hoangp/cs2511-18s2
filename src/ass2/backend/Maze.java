package ass2.backend;

public class Maze {
	private final int width;
	private final int height;
	private final Square[][] board;
	private Player player; // reference to the player for convenience
	
	public Maze(int width, int height) {
		this.width = width;
		this.height = height;
		
		// initialize empty board with EmptyTile
		board = new Square[height][width];
		for (int row=0; row<height; row++) {
			for (int col=0; col<width; col++) {
				board[row][col] = new Square(col, row);
			}
		}
		
		// set adjacent squares for each square
		for (int row=0; row<height; row++) {
			for (int col=0; col<width; col++) {
				if (row != 0)          board[row][col].setAboveSquare(board[row - 1][col]);
				if (row != height - 1) board[row][col].setBelowSquare(board[row + 1][col]);
				if (col != 0)          board[row][col].setLeftSquare (board[row][col - 1]);
				if (col != width - 1)  board[row][col].setRightSquare(board[row][col + 1]);
			}
		}
	}
	
	/**
	 * Add a player to the board
	 */
	public boolean addPlayer(int row, int col) {
		player = new Player();
		return add(player, row, col);
	}
	
	/**
	 * Add an entity to the board[row][col]
	 */
	public boolean add(Entity entity, int row, int col) {
		if (board[row][col].add(entity)) {
			entity.setSquare(board[row][col]);
			return true;
		}
		return false;
	}
	
	/**
	 * @return the player entity on the maze
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return the entity on top of board[row][col]
	 */
	public Entity getEntity(int row, int col) {
		return board[row][col].getEntity();
	}
	
	/**
	 * Print this maze
	 */
	public void print() {
		for (int row=0; row<height; row++) {
			for (int col=0; col<width; col++) {
				System.out.print(board[row][col].getSymbol());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Build a maze from string
	 */
	public static Maze parseMaze(int width, int height, String textMap) {
		Maze maze = new Maze(width, height);
		
		String[] lines = textMap.split("\n");
		for (int row=0; row<lines.length; row++) {
			String[] entities = lines[row].split(" ");
			for (int col=0; col<entities.length; col++) {
				switch (entities[col]) {
					case "P":
						maze.addPlayer(row, col);
					case "B":
						maze.add(new Boulder(), row, col);
					case "X":
						maze.add(new Wall(), row, col);
					case "S":
						maze.add(new Switch(), row, col);
				}
			}
		}
		
		return maze;
	}
}
