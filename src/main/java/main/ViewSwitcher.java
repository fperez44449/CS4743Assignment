package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import main.LoginViewController;
import View.SecondViewController;
import View.personViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewSwitcher implements Initializable {
	@FXML
    private BorderPane rootPane;
    private static ViewSwitcher instance = null;
    private ObservableList<Person> persons;
    private ViewSwitcher(){
    	persons= FXCollections.observableArrayList();
    	//PersonDisplayList = new ListView<Person>();
    	persons.add(new Person("Rafa","Nadal",34,"06/03/86"));
    	persons.add(new Person("Roger","Federer",39,"08/08/81"));
    	persons.add(new Person("Andy","Murray",33,"05/15/87"));
    	
    }
    public ObservableList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ObservableList<Person> persons) {
		this.persons = persons;
	}
	public static ViewSwitcher getInstance(){
    	if (instance == null)
    		instance = new ViewSwitcher();
    	return instance;
    }
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			switchView(ViewType.LoginView,null,-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public  void switchView(ViewType viewType,Person person, int check) throws IOException {
		// TODO Auto-generated method stub
		switch(viewType){
		case LoginView:		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("./LoginView.fxml"));
		loader.setController(new LoginViewController());
		Parent rootNode = loader.load();
		
		rootPane.setCenter(rootNode);
		break;
		case SecondView:
			loader = new FXMLLoader(this.getClass().getResource("../View/SecondView.fxml"));
			loader.setController(new SecondViewController(person,check));
			rootNode = loader.load();
	
			rootPane.setCenter(rootNode);
			break;
		case PersonView:
			loader = new FXMLLoader(this.getClass().getResource("../View/PersonView.fxml"));
			loader.setController(new personViewController(person,check));
			rootNode = loader.load();
	
			rootPane.setCenter(rootNode);
			default:
				break;

			
		
		
		}
		
	}


}
