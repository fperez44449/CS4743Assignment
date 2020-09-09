package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import main.Person;
import main.ViewSwitcher;
import main.ViewType;

public class SecondViewController implements Initializable {

    @FXML
    private BorderPane rootPane;

    @FXML
    private ObservableList<Person> persons;
    @FXML
    private ListView<String> PersonDisplayList;

    public SecondViewController(Person person, int check){
    	
    	persons=ViewSwitcher.getInstance().getPersons();
    	
    	
      //PersonDisplayList.getItems().addAll(persons);
    	//persons.get(0).toString()
    }
    @FXML
    void DeleteButtonPressed(ActionEvent event) throws IOException {
    	int check = PersonDisplayList.getSelectionModel().getSelectedIndex();
    	if(check > -1){
    	System.out.println("DELETING " + persons.get(check).getFirstName() + " "+ persons.get(check).getLastName());
        ViewSwitcher.getInstance().getPersons().remove(check);
        ViewSwitcher.getInstance().switchView(ViewType.SecondView,null,-1); 
    	}
    	}

    @FXML
    void addPersonButtonPressed(ActionEvent event) throws IOException {
     int check = PersonDisplayList.getSelectionModel().getSelectedIndex();
     if (check > -1){
    	 ViewSwitcher.getInstance().switchView(ViewType.PersonView,persons.get(check),check); 
     }
     if (check==-1){
    	 ViewSwitcher.getInstance().switchView(ViewType.PersonView,null,-1); 
     }
     }
    public void initialize(URL arg0, ResourceBundle arg1) {
		for(int i = 0;i<persons.size();i++){
    	String person2 = persons.get(i).getFirstName() + " " +persons.get(i).getLastName() +" "+ persons.get(i).getAge() +" "+ persons.get(i).getDateOfBirth();
    	PersonDisplayList.getItems().add(person2);
		}
    }

}
