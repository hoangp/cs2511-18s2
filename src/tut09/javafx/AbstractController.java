package tut09.javafx;

import javafx.stage.Stage;

public abstract class AbstractController {
	protected Stage stage;

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
