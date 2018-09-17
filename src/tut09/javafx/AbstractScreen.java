package tut09.javafx;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AbstractScreen {
	protected Stage stage;
	private String title;
	private FXMLLoader fxmlLoader;
	private Object controller;

	public AbstractScreen(Stage stage, String title, String fxmlFile, Object controller) {
		this.stage = stage;
		this.title = title;
		this.fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
		this.controller = controller;
	}

	public void start() {
		stage.setTitle(title);
		fxmlLoader.setController(controller);
		try {
			Parent root = fxmlLoader.load();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
