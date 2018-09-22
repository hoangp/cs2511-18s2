package tut09.javafx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class HeroController extends AbstractController {
	public HeroController(Stage stage) {
		super(stage);
	}

	private double squareSize = 50;
	private int mazeWidth = 8;
	private int mazeHeight = 6;

	@FXML private ImageView heroImage;
	@FXML private ImageView tileImage;
	@FXML private ImageView wallImage;
	@FXML private ImageView swordImage;
	@FXML private ImageView exitImage;
	@FXML private ImageView treasureImage;
	@FXML private Button backButton;
	@FXML private Pane mazePane;
	@FXML private TilePane designPane;

	private GridPane gridPane;
	private Map<Point, StackPane> gridStacks;
	private List<ImageView> entityImages;
	private Point heroPosition;
	private Random random = new Random();

	@FXML
	public void handleBackButton() {
		StartScene scene = new StartScene(stage);
		scene.start();
	}

	@FXML
	public void handleRandomizeButton() {
		mazeWidth = 3 + random.nextInt(6);  // random width 3 -> 8
		mazeHeight = 3 + random.nextInt(4); // random height 3 -> 6
		mazePane.getChildren().remove(gridPane);
		resetMaze();
	}

	@FXML
	public void initialize() {
		entityImages = Arrays.asList(wallImage, treasureImage, swordImage, exitImage);
		for (ImageView imageEntity : entityImages) {
			ImageView image = imageCopy(imageEntity);
			makeDraggable(image);
			designPane.getChildren().add(image);
		}
		resetMaze();
	}

	private void resetMaze() {
		gridStacks = new HashMap<>();
		heroPosition = new Point(0, 0);
		gridPane = initGridPane();
		gridStacks.get(heroPosition).getChildren().add(heroImage);
		mazePane.getChildren().add(gridPane);
	}

	private void makeDraggable(ImageView node) {
		node.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Dragboard db = node.startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				content.putImage(node.getImage());
				db.setContent(content);
				event.consume();
			}
		});
	}

	private ImageView imageCopy(ImageView srcImage) {
		ImageView image = new ImageView(srcImage.getImage());
		image.setFitWidth(squareSize);
		image.setFitHeight(squareSize);
		return image;
	}

	private StackPane stackCopy(ImageView image) {
		StackPane stack = new StackPane();
		stack.setMaxSize(squareSize, squareSize);
		stack.setMinSize(squareSize, squareSize);
		stack.getChildren().add(image);
		makeDroppable(stack);
		return stack;
	}

	private void makeDroppable(StackPane stack) {
		stack.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.ANY);
				}
				event.consume();
			}
		});
		stack.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				if (db.hasImage()) {
					System.out.println("sdfgsfdg");
					stack.getChildren().add(imageCopy(new ImageView(db.getImage())));
				}
				event.consume();
			}
		});
	}

	private GridPane initGridPane() {
		GridPane grid = new GridPane();
		for (int i = 0; i < mazeWidth; i++) {
			for (int j = 0; j < mazeHeight; j++) {
				StackPane stack = stackCopy(imageCopy(tileImage));

				// Put random entities on maze
				if (random.nextInt(4) == 0) {
					ImageView image = imageCopy(entityImages.get(random.nextInt(entityImages.size())));
					stack.getChildren().add(image);
				}

				grid.add(stack, i, j);
				gridStacks.put(new Point(i, j), stack); // bad code, just for convenience
			}
		}
		grid.autosize();
		return grid;
	}

	@FXML
	public void handleKeyPressed(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
			moveHeroBy(0, -1);
			break;
		case DOWN:
			moveHeroBy(0, 1);
			break;
		case LEFT:
			moveHeroBy(-1, 0);
			break;
		case RIGHT:
			moveHeroBy(1, 0);
			break;
		default:
			break;
		}
		event.consume();
	}

	private void moveHeroBy(int dx, int dy) {
		moveHeroTo(heroPosition.x + dx, heroPosition.y + dy);
	}

	private void moveHeroTo(int x, int y) {
		if (x >= 0 && x < mazeWidth && y >= 0 && y < mazeHeight) {
			List<Node> stackChildren = gridStacks.get(heroPosition).getChildren();
			stackChildren.remove(stackChildren.size() - 1);
			heroPosition = new Point(x, y);
			gridStacks.get(heroPosition).getChildren().add(heroImage);
		}
	}

	private class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Point other = (Point) obj;
			if (x != other.x) return false;
			if (y != other.y) return false;
			return true;
		}
	}
}
