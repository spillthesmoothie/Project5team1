package bsu.comp152;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class search implements Initializable {
    private String starType;
    private String starName;
    private String dataList;
    private armoury Model;

    public search(String type,String name){
        starType= type;
        starName = name;
    }
    public void loadData(){
        String query = getQueryParam();
        Model = new armoury(query);
        dataList = Model.getData(starType);
    }
    public String getDataList(){return dataList;}
    private String getQueryParam(){return "https://swapi.co/api/" + starType + "/?search=" + starName;}
    public void setStarType(String type){starType = type;}
    public void setStarName(String name){starName = name;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}