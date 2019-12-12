package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;

public class main extends Application {

    public static void main(String[] args){launch(args);}


    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        var loc = getClass().getResource("Main1.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 300,400);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("Demo to Nudge you in the right direction");
        primaryStage.show();
    }

    @FXML
    public void exit(ActionEvent event){
        System.exit(0);//alls well - bye bye
    }
    public void openStarButton(Stage stage) throws Exception{
        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(10,10, 10, 10));
        box.setSpacing(10);

        starButton buttOne = new starButton("Star Wars");
        box.getChildren().addAll((Collection<? extends Node>) buttOne);
        var container = new Scene(box);
        stage.setScene(container);
        stage.setTitle("Star Wars");
        stage.setWidth(400);
        stage.setHeight(600);
        stage.show(); }}



