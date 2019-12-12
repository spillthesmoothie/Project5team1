package bsu.comp152;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class starButton{
    private String name;

    public starButton(String title) { name = title; }

    public Button makeButton() {
        Button button = new Button(name);
        button.setMaxSize(390, 150);
        button.setMinSize(390, 150);

        button.setFont(Font.loadFont(getClass().getResourceAsStream("star wars api title.jpg"), 50));
        button.setTextFill(Paint.valueOf("yellow"));
        button.setStyle("-fx-background-color: " + "black");


        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                starHandler sw = new starHandler();
                sw.displayWindow();
            }
        };
        button.setOnAction(handler);

        return button;
    }

}


