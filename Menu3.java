package com.example.demo1;

import java.util.HashSet;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Math.pow;

public class Menu3 {

    public static boolean hasDuplicateTextFields(TextField[] textFields) {
        HashSet<String> uniqueTexts = new HashSet<>(); // create a set to contain existed names

        for (TextField textField : textFields) {
            String text = textField.getText(); // get each new name
            if (uniqueTexts.contains(text)) { // whether the new coming name has existed before
                return true; // the usernames duplicate
            }
            uniqueTexts.add(text);
        }

        return false; // no duplicate
    }
        static Button buttonEnter;
        public static Scene createSceneOfMenu3(Stage stage) throws FileNotFoundException {
            FileInputStream inputMenu3 = new FileInputStream("out/scrabble.png");
            Image imageMenu3 = new Image(inputMenu3);
            ImageView imageViewMenu3 = new ImageView(imageMenu3);
            imageViewMenu3.setFitWidth(900);
            imageViewMenu3.setFitHeight(600);
            buttonEnter = new Button("Enter");
            buttonEnter.setTranslateX(370);
            buttonEnter.setTranslateY(400);
            buttonEnter.setPrefSize(100,40);
            Font myFont = new Font("Arial", 15);
            buttonEnter.setFont(myFont);  // create an EnterButton

            Label[] typingPlayerName = new Label[4];
            Label noticeLabel = new Label("* Don't input same usernames!");
            noticeLabel.setLayoutX(350);
            noticeLabel.setLayoutY(350);
            noticeLabel.setStyle("-fx-text-fill: white");
            Group groupOfMenu3 = new Group();
            groupOfMenu3.getChildren().addAll(imageViewMenu3,buttonEnter,noticeLabel);
            TextField[] playerName = new TextField[chessBoard.playerNum]; // create TextFields to contain names
            for(int i=0; i<chessBoard.playerNum; i++){
                playerName[i] = new TextField();
                if(i==0) {
                    playerName[i].setLayoutX(350);
                    playerName[i].setLayoutY(250 + i * pow(-1, i) * 60);
                    playerName[i].setPrefSize(150, 30);
                    typingPlayerName[i] = new Label("Player Name");
                    typingPlayerName[i].setLayoutX(350);
                    typingPlayerName[i].setLayoutY(230+i * pow(-1, i) * 60);
                }
                else{
                    playerName[i].setLayoutX(350);
                    playerName[i].setLayoutY(playerName[i-1].getLayoutY() + i * pow(-1, i) * 60);
                    playerName[i].setPrefSize(150, 30);
                    typingPlayerName[i] = new Label("Player Name");
                    typingPlayerName[i].setLayoutX(350);
                    typingPlayerName[i].setLayoutY(typingPlayerName[i-1].getLayoutY()+i*pow(-1,i)*60);
                    if(i==2)
                        typingPlayerName[i].setStyle("-fx-text-fill: white");
                } // this program is set for proper locations of TextField designing for different number of player
                groupOfMenu3.getChildren().add(typingPlayerName[i]);
                groupOfMenu3.getChildren().add(playerName[i]);
            }

            Menu3.buttonEnter.setOnAction(e->{
                for(int i=0; i<chessBoard.playerNum; i++){
                    if(playerName[i].getText().isEmpty()
                            || hasDuplicateTextFields(playerName))
                        return;
                    Menu2.player[i].playerName = playerName[i].getText(); // transfer what inputted in TextField to playerNames
                }
                try {
                    stage.setScene(chessBoard.createSceneOfBoard(stage));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });
            Scene sceneOfMenu3 = new Scene(groupOfMenu3,900,600);
            buttonEnter.setCursor(Cursor.OPEN_HAND);
            return sceneOfMenu3;
        }
}
