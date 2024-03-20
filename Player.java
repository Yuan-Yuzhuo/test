package com.example.demo1;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Scanner;

public class Player {
    LetterBag letterBag = new LetterBag();
    String playerName = " ";
    int playerScore = 0;
    int timeOfPlayer = 0;
    char[] letterBlock = new char[7];
    //Group groupOfPlayer = new Group();

    Image[] imageOfLetter = new Image[7];
    ImageView[] imageViewsOfLetter = new ImageView[7];
    public Player() {
        for (int i = 0; i < 7; i++) {
            letterBlock[i] = letterBag.drawLetter();
            imageOfLetter[i] = ScrabbleGame.getImage(letterBlock[i]);
            imageViewsOfLetter[i] = new ImageView(imageOfLetter[i]);
            imageViewsOfLetter[i].setFitWidth(20);
            imageViewsOfLetter[i].setFitHeight(20);
            double x = 600;
            double y = 100 + i * 50;
            imageViewsOfLetter[i].setLayoutX(x);
            imageViewsOfLetter[i].setLayoutY(y);
            //groupOfPlayer.getChildren().add(imageViewsOfLetter[i]);
        }
    }


    public static void main(String[] args) {
        Player player = new Player();
        for (int i = 0; i < 7; i++) {
            System.out.println(player.letterBlock[i]);
        }
    }
}

