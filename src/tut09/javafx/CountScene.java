package tut09.javafx;

import javafx.stage.Stage;

public class CountScene extends AbstractScene {
	public CountScene(Stage stage) {
		super(stage, "Count Screen", "count.fxml", new CountController(stage));
	}
}
