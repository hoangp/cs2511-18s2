package tut09.javafx;

import javafx.fxml.FXML;

public class StartController extends AbstractController {
  public StartController() {}

	@FXML
	public void handleCountButton() {
		CountScene scene = new CountScene(stage);
		scene.start();
	}
	
	@FXML
	public void handleListButton() {
		ListScene scene = new ListScene(stage);
		scene.start();
	}
	
	@FXML
	public void handleHeroButton() {
		HeroScene scene = new HeroScene(stage);
		scene.start();
	}
	
	@FXML
	public void handleExitButton() {
		stage.close();
	}
}
