package bsu.comp152;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class RoneshWeatherController {
    @FXML
    private ListView<RoneshDataHandler.weatherData> ListControl;
    private RoneshDataHandler Model;
    @FXML
    private Button search;
    @FXML
    private Button current;
    @FXML
    private Button days;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextArea citynametext;
    @FXML
    private TextArea woeidtext;



    public void loadData(){
        var site = "https://www.metaweather.com/api/";
        var params = getQueryParameters();
        var query = site+params;
        Model = new RoneshDataHandler(query);
        var weatherList = Model.getData();
        ObservableList<RoneshDataHandler.weatherData> dataToShow =
                FXCollections.observableArrayList(weatherList);
        ListControl.setItems(dataToShow);

    }

    private String getCity(){
        citynametext.setEditable(true);
        citynametext.setText("New");
        var nameofcity = citynametext.getText();
        return nameofcity;


    }
    private String getWoeid(){
        woeidtext.setText("44418");
        woeidtext.setEditable(true);
        var woeidgetter = woeidtext.getText();
        return woeidgetter;
    }

    private  String getdate(){
        datepicker.setEditable(true);
        
    }
    public String getQueryParameters(){




    }
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);//will exit the program
}}
