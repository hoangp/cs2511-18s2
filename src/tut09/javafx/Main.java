package tut09.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	  primaryStage.setResizable(false);
		StartScene screen = new StartScene(primaryStage);
		screen.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
