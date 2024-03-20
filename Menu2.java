package com.example.demo1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu2 {
    public static Button confirmButton;
    public static TextField typingPlayerNum;
    public static TextField typingGoalScore;
    public static Player[] player = new Player[chessBoard.playerNum]; // create player stances
    public static Font myFont = new Font("Arial", 15);

    public static Scene createSceneOfMenu2(Stage stage) throws FileNotFoundException {
        FileInputStream inputGame = new FileInputStream("out/scrabble.png");
        Image imageGame = new Image(inputGame);
        ImageView imageViewGame001 = new ImageView(imageGame);
        imageViewGame001.setFitWidth(900);
        imageViewGame001.setFitHeight(600);   // create the background

        // provide gadgets
        Label text1 = new Label("Number of players (2~4)");
        Label text2 = new Label("Goal score (50~200)");
        myFont = new Font("Arial", 15);
        text1.setLayoutX(370);
        text1.setLayoutY(275);
        text2.setLayoutX(370);
        text2.setLayoutY(175);
        text1.setFont(myFont);
        text2.setFont(myFont);
        text1.setStyle("-fx-opacity: 1;-fx-text-fill: white");
        text2.setStyle("-fx-opacity: 1;");

        typingPlayerNum = new TextField();
        typingGoalScore = new TextField();  // programmer should initialize the objects in methods
        typingPlayerNum.setLayoutX(370);
        typingPlayerNum.setLayoutY(300);
        typingGoalScore.setLayoutX(370);
        typingGoalScore.setLayoutY(200);  // complete setting two texts

        confirmButton = new Button("Confirm");
        confirmButton.setTranslateX(400);
        confirmButton.setTranslateY(400);
        confirmButton.setPrefSize(100, 40);
        confirmButton.setFont(myFont);
        confirmButton.setTranslateX(400);
        confirmButton.setTranslateY(400);
        confirmButton.setPrefSize(100, 40);
        confirmButton.setFont(myFont);  // complete setting the button

        confirmButton.setOnAction(e -> {
            chessBoard.playerNum = Integer.parseInt(typingPlayerNum.getText());
            chessBoard.scoreGoal = Integer.parseInt(typingGoalScore.getText());
            if (chessBoard.playerNum > 4 || chessBoard.playerNum < 2
                    || chessBoard.scoreGoal > 200 || chessBoard.scoreGoal < 50)
                return;

            player = new Player[chessBoard.playerNum];  // create the stances of Player
            for(int i=0; i<chessBoard.playerNum; i++){
                player[i] = new Player();
            }

            try {
                stage.setScene(Menu3.createSceneOfMenu3(stage));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Group groupGame001 = new Group();
        groupGame001.getChildren().addAll(imageViewGame001, typingPlayerNum, typingGoalScore, text1, text2, confirmButton);
        Scene sceneGame = new Scene(groupGame001, 900, 600);

        confirmButton.setCursor(Cursor.OPEN_HAND);
        return sceneGame;
    }
}