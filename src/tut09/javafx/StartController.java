package tut09.javafx;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class StartController extends AbstractBaseController {
	public StartController(Stage stage) {
		super(stage);
	}

	@FXML
	public void handleCounterButton() {
		CountScreen screen = new CountScreen(stage);
		screen.start();
	}
}
