package tut09.javafx;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class StartController extends AbstractController {
	public StartController(Stage stage) {
		super(stage);
	}

	@FXML
	public void handleCounterButton() {
		CountScene scene = new CountScene(stage);
		scene.display();
	}
	
	@FXML
	public void handleListViewButton() {
		ListScene scene = new ListScene(stage);
		scene.display();
	}
}
