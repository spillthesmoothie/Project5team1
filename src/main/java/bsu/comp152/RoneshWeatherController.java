package bsu.comp152;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

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
    @FXML
    private ListView listControl;



    public void loadData1(String cityname){
        var site = "https://www.metaweather.com/api/location/search/?query=";
        var query = site+cityname;
        Model = new RoneshDataHandler(query);
        var weatherList = Model.getData();
        ObservableList<RoneshDataHandler.weatherData> dataToShow =
                FXCollections.observableArrayList(weatherList);
        ListControl.setItems(dataToShow);

    }



    public void loadData(){
        var site = "https://www.metaweather.com/api/location/";
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
        var getthedate = datepicker.getAccessibleText();
        return getthedate;
    }


    private void showData(){

    }



    public String getQueryParameters(){
        var getDate = getdate();
        var getWoeid = getWoeid();
        String param = "";
        if (getWoeid.isBlank()){
            System.out.println("No Woeid Selected, Search for city's woeid");
            loadData1(getCity());

        }else {
            param = getWoeid;
            loadData();
        }

        return param;
            }
    @FXML
    public void exit(ActionEvent event){
        System.exit(0);//will exit the program
}
    @FXML
    public void search(ActionEvent event){
        loadData1(getCity());
        listControl.getItems();





}}

