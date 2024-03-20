package com.example.demo1;

import javafx.application.Application;
import javafx.stage.Stage;



public class myScrabble extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Scrabble"); // set title of stage
        stage.setResizable(false); // cancel the function of resizing
        stage.setScene(Menu1.createSceneOfMenu1(stage)); // calling the scene of Menu2
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // which is not essential
        ScrabbleGame scrabbleGame = new ScrabbleGame();
        LetterBag letterBag = new LetterBag();
    }
}