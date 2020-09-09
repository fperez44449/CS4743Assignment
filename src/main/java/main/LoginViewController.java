package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

public class LoginViewController {

    @FXML
    private PasswordField password;

    @FXML
    private BorderPane rootPane;

    @FXML
    private PasswordField userName;

    @FXML
    void LoginButtonPressed(ActionEvent event) throws IOException {
    ViewSwitcher.getInstance().switchView(ViewType.SecondView,null,-1);
    System.out.println("READING Rafal Nadal");
	System.out.println("READING Roger Federer");
	System.out.println("READING Andy Murray");
    }

}
