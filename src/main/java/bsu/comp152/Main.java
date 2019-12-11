package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        var loc = getClass().getResource("Main.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 600,600);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("Main Window");
        primaryStage.show();
    }

    @FXML
    public void exit(ActionEvent event){
        System.exit(0);//will exit the program
    }

    @FXML
    public  void openWeatherWindow(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("WeatherWindow.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 900,400);
        Stage WeatherWindow = new Stage();
        WeatherWindow.setScene(windowContents);
        WeatherWindow.setTitle("Weatherapp by Ronesh");
        WeatherWindow.show();
    }
    @FXML
    public  void openAnthony(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("Anthony.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 900,400);
        Stage AnthonyWindow = new Stage();
        AnthonyWindow.setScene(windowContents);
        AnthonyWindow.setTitle("Anthony");
        AnthonyWindow.show();
    }

    @FXML
    public  void openKevin(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("Kevin.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 900,400);
        Stage KevinWindow = new Stage();
        KevinWindow.setScene(windowContents);
        KevinWindow.setTitle("Anthony");
        KevinWindow.show();
    }

    @FXML
    public  void openTrey(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("Kevin.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 900,400);
        Stage TreyWindow = new Stage();
        TreyWindow.setScene(windowContents);
        TreyWindow.setTitle("Anthony");
        TreyWindow.show();
    }
}