package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application {
	@FXML
    private BorderPane rootPane;

	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage stage) throws Exception{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("./Main.fxml"));
		loader.setController(ViewSwitcher.getInstance());
		Parent rootNode=loader.load();
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.setTitle("Assignment1");
		stage.show();
		
		//ViewSwitcher.switchview(ViewType.LoginView);
		
		
	}

	
}
