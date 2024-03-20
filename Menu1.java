package com.example.demo1;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu1 {
    public static Button buttonStart;
    public static Scene createSceneOfMenu1(Stage stage) throws FileNotFoundException {
        FileInputStream inputMenu = new FileInputStream("out/start.jpg"); // loading the figure
        Image imageMenu = new Image(inputMenu);
        ImageView imageViewMenu = new ImageView(imageMenu);  // put it in ImageView
        imageViewMenu.setFitWidth(900);
        imageViewMenu.setFitHeight(600); // set size of figure
        buttonStart = new Button();
        buttonStart.setPrefSize(800, 90);
        buttonStart.setTranslateX(85);
        buttonStart.setTranslateY(215);
        buttonStart.setStyle("-fx-background-color: rgba(255, 192, 203, 0); " +
                "-fx-border-color: grey; -fx-border-width: 3px;"); // set a button with a special design
        Menu1.buttonStart.setOnAction(e -> {
            try {
                stage.setScene(Menu2.createSceneOfMenu2(stage));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }); // click event to enter the second page

        buttonStart.setOnMouseEntered(event -> {
            buttonStart.setStyle(" -fx-background-color: rgba(255, 192, 203, 0);" +
                    " -fx-border-color: lightgray; -fx-border-width: 3px;");
        }); // mouse enter event

        buttonStart.setOnMouseExited(event -> {
            buttonStart.setStyle(" -fx-background-color: rgba(255, 192, 203, 0); " +
                    "-fx-border-color: grey; -fx-border-width: 3px;");
        }); // mouse leave event

        Group groupMenu = new Group();
        groupMenu.getChildren().addAll(imageViewMenu, buttonStart); // get them into a group
        Scene sceneMenu = new Scene(groupMenu, 900, 600);
        buttonStart.setCursor(Cursor.OPEN_HAND);
        return sceneMenu;
    }
}
