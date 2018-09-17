package tut09.javafx;

import javafx.stage.Stage;

public class StartScreen extends AbstractBaseScreen {
	public StartScreen(Stage stage) {
		super(stage, "Start Screen", "start.fxml", new StartController(stage));
	}
}
