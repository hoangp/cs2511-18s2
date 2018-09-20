package tut09.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CountController extends AbstractController {
	private int counter = 0;

	public CountController(Stage stage) {
		super(stage);
	}

	@FXML private TextField numberField;

	@FXML
	public void initialize() {
		numberField.setText(String.valueOf(counter));
	}

	@FXML
	public void handleBackButton() {
		StartScene screen = new StartScene(stage);
		screen.start();
	}

	@FXML
	public void handlePlusButton() {
		numberField.setText(String.valueOf(++counter));
	}

	@FXML
	public void handleMinusButton() {
		if (counter > 0) numberField.setText(String.valueOf(--counter));
	}

}
