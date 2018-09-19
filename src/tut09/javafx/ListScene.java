package tut09.javafx;

import javafx.stage.Stage;

public class ListScene extends AbstractScene {
	public ListScene(Stage stage) {
		super(stage, "My List App", "list.fxml", new ListController(stage));
	}
}
