package tut09.javafx;

import javafx.stage.Stage;

public class CountScreen extends AbstractScreen {
	public CountScreen(Stage stage) {
		super(stage, "Count Screen", "count.fxml", new CountController(stage));
	}
}
