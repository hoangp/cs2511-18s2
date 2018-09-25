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
				if (row != 0)          board[row][col].setTop   (board[row - 1][col]);
				if (row != height - 1) board[row][col].setBottom(board[row + 1][col]);
				if (col != 0)          board[row][col].setLeft  (board[row][col - 1]);
				if (col != width - 1)  board[row][col].setRight (board[row][col + 1]);
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Square getSquare(int row, int col) {
		return board[row][col];
	}
	
	public Entity getEntity(int row, int col) {
		return getSquare(row, col).getEntity();
	}
	
	private boolean add(Entity entity, int row, int col) {
		if (board[row][col].add(entity)) {
			entity.setSquare(board[row][col]);
			return true;
		}
		return false;
	}
	
	public static Maze parseMaze(int width, int height, String text) {
		Maze maze = new Maze(width, height);
		
		String[] lines = text.split("\n");
		for (int row=0; row<lines.length; row++) {
			String[] entities = lines[row].split(" ");
			for (int col=0; col<entities.length; col++) {
				switch (entities[col]) {
					case "P":
						Player player = new Player();
						if (maze.add(player, row, col)) {
							maze.setPlayer(player);
						}
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
	
	public void print() {
		for (int row=0; row<height; row++) {
			for (int col=0; col<width; col++) {
				System.out.print(board[row][col].getSymbol());
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String text = "X X X X X\n" + 
									"X P . . .\n" + 
									"X . B . .\n" + 
									"X . . S .\n" + 
									"X . . . .\n";
		Maze maze = Maze.parseMaze(5, 5, text);
		maze.print();
		
		Player player = maze.getPlayer();
		player.moveRight();
		player.moveDown();
		maze.print();
		player.moveDown();
		maze.print();
	}

}
