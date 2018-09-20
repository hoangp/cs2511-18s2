package tut09.javafx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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

	private GridPane gridPane;
	private Map<Point, StackPane> stacks;
	private Point heroPosition;
	Random random = new Random();

	@FXML
	public void initialize() {
		stacks = new HashMap<>();
		heroPosition = new Point(0, 0);
		initGridPane();
		mazePane.getChildren().add(gridPane);
		stacks.get(heroPosition).getChildren().add(heroImage);
	}

	@FXML
	public void handleResetButton() {
		mazeWidth = 3 + random.nextInt(6);
		mazeHeight = 3 + random.nextInt(4);
		mazePane.getChildren().remove(gridPane);
		initialize();
	}

	private ImageView imageCopy(ImageView srcImage) {
		ImageView image = new ImageView();
		image.setImage(srcImage.getImage());
		image.setFitWidth(squareSize);
		image.setFitHeight(squareSize);
		return image;
	}

	public void initGridPane() {
		gridPane = new GridPane();
		List<ImageView> entities = new ArrayList<>();
		entities.add(wallImage);
		entities.add(treasureImage);
		entities.add(swordImage);
		entities.add(exitImage);
		for (int i = 0; i < mazeWidth; i++) {
			for (int j = 0; j < mazeHeight; j++) {
				ImageView image = new ImageView();
				image.setImage(tileImage.getImage());
				image.setFitWidth(squareSize);
				image.setFitHeight(squareSize);

				StackPane stack = new StackPane();
				stack.setMaxSize(squareSize, squareSize);
				stack.setMinSize(squareSize, squareSize);
				stack.getChildren().add(imageCopy(tileImage));

				if (random.nextInt(4) == 0) {
					image = imageCopy(entities.get(random.nextInt(entities.size())));
					stack.getChildren().add(image);
				}

				gridPane.add(stack, i, j);
				stacks.put(new Point(i, j), stack);
			}
		}
		gridPane.autosize();
	}

	@FXML
	public void handleBackButton() {
		StartScene scene = new StartScene(stage);
		scene.start();
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
		int x = heroPosition.x + dx;
		int y = heroPosition.y + dy;
		moveHeroTo(x, y);
	}

	private void moveHeroTo(int x, int y) {
		if (x >= 0 && x < mazeWidth && y >= 0 && y < mazeHeight) {
			List<Node> nodes = stacks.get(heroPosition).getChildren();
			nodes.remove(nodes.size() - 1);
			heroPosition = new Point(x, y);
			stacks.get(heroPosition).getChildren().add(heroImage);
		}
	}

	class Point {
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
