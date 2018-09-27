package ass2.backend;

public class Maze {
  private final int width;
  private final int height;
  private final Square[][] board;
  private Player player; // there is only 1 player in the maze
  
  public Maze(String textMaze) {
    // get width and height of the maze
    String[] rows = textMaze.split("\n");
    String[] row0 = rows[0].split(" ");
    this.width = row0.length;
    this.height = rows.length;

    // initialize empty board with EmptyTile
    board = new Square[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        board[row][col] = new Square(row, col);
      }
    }

    // set adjacent squares for each square
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (row != 0) board[row][col].setAboveSquare(board[row - 1][col]);
        if (row != height - 1) board[row][col].setBelowSquare(board[row + 1][col]);
        if (col != 0) board[row][col].setLeftSquare(board[row][col - 1]);
        if (col != width - 1) board[row][col].setRightSquare(board[row][col + 1]);
      }
    }

    // parsing textMaze into this maze
    String[] lines = textMaze.split("\n");
    for (int row = 0; row < lines.length; row++) {
      String[] entities = lines[row].split(" ");
      for (int col = 0; col < entities.length; col++) {
        switch (entities[col]) {
          case "P":
            player = new Player();
            add(player, row, col);
            break;
          case "X":
            add(new Wall(), row, col);
            break;
          case "B":
            add(new Boulder(), row, col);
            break;
          case "S":
            add(new Switch(), row, col);
            break;
        }
      }
    }
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
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        System.out.print(board[row][col].getSymbol());
      }
      System.out.println();
    }
    System.out.println();
  }
}
