package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.Person;
import main.ViewSwitcher;
import main.ViewType;

public class personViewController implements Initializable {

    @FXML
    private TextField agefield;

    @FXML
    private TextField dateofbirth;

    @FXML
    private BorderPane rootPane;

    @FXML
    private TextField lastfield;

    @FXML
    private TextField firstfield;

    private Person person;
    private int check;
    @FXML
    void SaveButtonPressed(ActionEvent event) throws IOException {
      this.person.setFirstName(firstfield.getText());
      this.person.setLastName(lastfield.getText());
      this.person.setAge(Integer.parseInt(agefield.getText()));
      this.person.setDateOfBirth(dateofbirth.getText());
      if(check > ViewSwitcher.getInstance().getPersons().size()){
    	  System.out.println("CREATING " + this.person.getFirstName() + " "+ this.person.getLastName());
    	  ViewSwitcher.getInstance().getPersons().add(person);
    	  ViewSwitcher.getInstance().switchView(ViewType.SecondView,this.person,this.check);
      }
      else{
    	  System.out.println("UPDATING " + this.person.getFirstName() + " "+ this.person.getLastName());
      ViewSwitcher.getInstance().getPersons().set(this.check, this.person);
      ViewSwitcher.getInstance().switchView(ViewType.SecondView,this.person,this.check);
      }
    }

    @FXML
    void CancelButtonPressed(ActionEvent event) throws IOException {
    	 ViewSwitcher.getInstance().switchView(ViewType.SecondView,null,-1);
    }
    public personViewController(Person person, int check){
    	if(person ==null &&check ==-1){
    		this.person=new Person("John", "Doe", 0,"0/00/0000");
    		this.check=ViewSwitcher.getInstance().getPersons().size()+1;
    	}
    	else{
    	this.person=person;
    	this.check=check;
    	}
    }
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		firstfield.setText(this.person.getFirstName());
		lastfield.setText(this.person.getLastName());
		agefield.setText(String.valueOf(this.person.getAge()));
		dateofbirth.setText(this.person.getDateOfBirth());
	}

}
