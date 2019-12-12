package bsu.comp152;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class starHandler {

    private String responseType;
    private String nameType;
    private search controller;

    public void displayWindow() {
        Stage stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(600);
        stage.setTitle("Star Wars");

        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(10, 0, 0, 0));

        Label lblOne = new Label("Do you want to see people or planets?");



        TextField textFieldOne = new TextField();
        Label lblTwo = new Label("What is the name?");
        TextField textFieldTwo = new TextField();
        Button submit = new Button("Submit");
        Button clear = new Button("Clear data");


        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(100);
        hbox.getChildren().addAll(submit, clear);

        controller = new search("", "");
        ListView listControl = new ListView();


        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                responseType = textFieldOne.getText().toLowerCase();
                nameType = textFieldTwo.getText();
                controller.setStarType(responseType);
                nameType = nameType.replace(' ', '+');
                controller.setStarName(nameType);
                controller.loadData();
                listControl.getItems().add(controller.getDataList());
            }
        };
        submit.setOnAction(handler);

        EventHandler<ActionEvent> handlerTwo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listControl.getItems().clear();
            }
        };
        clear.setOnAction(handlerTwo);

        box.getChildren().addAll(lblOne, textFieldOne, lblTwo, textFieldTwo, hbox, listControl);

        stage.setScene(new Scene(box));
        stage.show();
    }
}

