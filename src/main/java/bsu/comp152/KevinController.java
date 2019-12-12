package bsu.comp152;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private CheckBox box1;
    @FXML
    private CheckBox box2;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField languageTextField;
    @FXML
    private ListView<DataHandler.jobDataType> listControl;
    @FXML 
    private Button exitButton;
    private DataHandler Model;
    private boolean fullTime;

    public void loadData(){
        var site = "https://jobs.github.com/api/";
        var params = getQueryParameters();
        var query = site+params;

        Model = new DataHandler(query);
        var jobList = Model.getData();
        ObservableList<DataHandler.jobDataType> dataToShow = FXCollections.observableArrayList(jobList);
        listControl.setItems(dataToShow);
    }

    public String getLanguage(){
        languageTextField.setText("Java");
        languageTextField.setEditable(true);
        var language = languageTextField.getText();
        return language;
    }

    public String getLocation(){
        locationTextField.setText("Boston");
        locationTextField.setEditable(true);
        var city = locationTextField.getText();
        return city;
    }

    public boolean isFullTime(){
        if (box1.isSelected())
            fullTime = true;
        else
            fullTime = false;
        return fullTime;
    }
 
    private String getQueryParameters(){
        var language = getLanguage();
        var location = getLocation();
        var full_time = isFullTime();
        return "description="+language+"&location="+location+"&full_time="+isFullTime();
    }

    @FXML
    public void search(javafx.event.ActionEvent actionEvent) { loadData(); }

    @FXML
    public void closeScene(javafx.event.ActionEvent actionEvent) {System.exit(-1);}
}

