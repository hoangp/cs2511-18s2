package tut09.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListController extends AbstractController {
	public ListController() {}

	@FXML
	public void initialize() {
		selectedLabel.setText("");
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				selectedLabel.setText(newValue + " selected");
			}
		});
	}

	@FXML private ListView<String> listView;
	@FXML private Label selectedLabel;
	@FXML private TextField addField;

	@FXML
	public void handleAddButton() {
		String item = addField.getText();
		if (!item.isEmpty()) listView.getItems().add(item);
	}

	@FXML
	public void handleRemoveButton() {
		String item = listView.getSelectionModel().getSelectedItem();
		if (!item.isEmpty()) listView.getItems().remove(item);
	}

	@FXML
	public void handleBackButton() {
		StartScene scene = new StartScene(stage);
		scene.start();
	}
}
