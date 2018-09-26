package tut09.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AbstractScene {
	protected Stage stage;
	private String title;
	private FXMLLoader fxmlLoader;

	public AbstractScene(Stage stage, String title, String fxmlFile) {
		this.stage = stage;
		this.title = title;
		this.fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
	}

	public void start() {
		stage.setTitle(title);

		try {
			Parent root = fxmlLoader.load();
      AbstractController controller = fxmlLoader.getController();
      controller.setStage(stage);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
