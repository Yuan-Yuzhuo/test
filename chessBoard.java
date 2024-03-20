package com.example.demo1;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class chessBoard {
    static int playerNum = 4;
    static int scoreGoal = 100;
    public static Label[] scoresOfPlayers = new Label[playerNum]; // create labels to show scores of each player
    private static boolean[] isMoving = new boolean[7];
    private static ImageView[] movingImages = new ImageView[7];
    private static ImageView[][] imageViewsOfBlock = new ImageView[15][15];
    private static String[][] letter1 = new String[15][15];

    private static ImageView[][] letter = new ImageView[playerNum][7];
    private static boolean[] bool = new boolean[7];
    private static Group groupOfBoard = new Group();
    int i = 0;


    // 初始化玩家分数标签
    private static void chessboard() {
        for (int i = 0; i < playerNum; i++) {
            scoresOfPlayers[i] = new Label(); // initialize the labels for n times, n equals to the number of player
        }
    }


    // 创造场景的函数
    public static Scene createSceneOfBoard(Stage stage) throws FileNotFoundException {


        // 准备所有变量
        FileInputStream inputBoard = new FileInputStream("out/production/棋盘（去背景）.png");
        FileInputStream inputBackGround = new FileInputStream("out/云彩.jpg");
        FileInputStream inputDefault = new FileInputStream("out/letters/微信图片_202403141125571.jpg");
        Image imageDefault = new Image(inputDefault);
        Image imageOfBoard = new Image(inputBoard);
        Image imageOfBackGround = new Image(inputBackGround);
        ImageView imageViewOfBoard = new ImageView(imageOfBoard);
        ImageView imageViewOfBackGround = new ImageView(imageOfBackGround);
        imageViewOfBackGround.setFitWidth(900);
        imageViewOfBackGround.setFitHeight(600);
        imageViewOfBoard.setFitWidth(600);
        imageViewOfBoard.setFitHeight(600);
        chessboard(); // achieve the method to create labels


        // 设置隐藏方格用来标定棋盘格子的位置
        double x, y;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                x = 70.0 / 1350 * 900 + i * (ChessBlock.len + ChessBlock.dis);
                y = 25.0 / 842 * 600 + j * (ChessBlock.len + ChessBlock.dis);
                imageViewsOfBlock[i][j] = new ImageView();
                imageViewsOfBlock[i][j].setFitWidth(20);
                imageViewsOfBlock[i][j].setFitHeight(20);
                imageViewsOfBlock[i][j].setImage(imageDefault);
                imageViewsOfBlock[i][j].setLayoutX(x);
                imageViewsOfBlock[i][j].setLayoutY(y);
                groupOfBoard.getChildren().add(imageViewsOfBlock[i][j]);
            }
        }


        Scene sceneBoard = new Scene(groupOfBoard, 900, 600);
        groupOfBoard.getChildren().addAll(imageViewOfBackGround, imageViewOfBoard);


        // 排布玩家分数标签
        for (int i = 0; i < playerNum; i++) {
            scoresOfPlayers[i].setText("score of " + Menu2.player[i].playerName + " :" + Menu2.player[i].playerScore);
            scoresOfPlayers[i].setFont(Menu2.myFont);
            if (i == 0) {
                scoresOfPlayers[i].setLayoutX(650);
                scoresOfPlayers[i].setLayoutY(50 + i * Math.pow(-1, i) * 60);
                scoresOfPlayers[i].setPrefSize(150, 30);
            } else {
                scoresOfPlayers[i].setLayoutX(650);
                scoresOfPlayers[i].setLayoutY(scoresOfPlayers[i - 1].getLayoutY() + i * Math.pow(-1, i) * 20);
                scoresOfPlayers[i].setPrefSize(150, 30);
            }
            groupOfBoard.getChildren().addAll(scoresOfPlayers[i]);
        } // set the proper positions of scores, like that in Menu3


        // 设置图片位移事件
        groupOfBoard.setOnMouseMoved(event -> {
            for (int i = 0; i < 7; i++) {
                if (isMoving[i] && movingImages[i] == Menu2.player[0].imageViewsOfLetter[i]) {
                    movingImages[i].setLayoutX(event.getSceneX() - movingImages[i].getFitWidth() / 2);
                    movingImages[i].setLayoutY(event.getSceneY() - movingImages[i].getFitHeight() / 2);
                }
            }
        });


        // 设一个scrabbleGame实例用于构造一个图和字母的hashmap
        ScrabbleGame scrabbleGame = new ScrabbleGame();


        for (int i = 0; i < 7; i++) {


            // 添加玩家的七个字母块到场景中
            groupOfBoard.getChildren().add(Menu2.player[0].imageViewsOfLetter[i]);


            int index = i;


            // 设置点击图片的放置和拿起事件
            Menu2.player[0].imageViewsOfLetter[index].setOnMouseClicked((MouseEvent event) -> {
                if (isMoving[index] && movingImages[index] == Menu2.player[0].imageViewsOfLetter[index]) {
                    double mouseX = event.getSceneX();
                    double mouseY = event.getSceneY();
                    for (int p = 0; p < 15; p++) {
                        for (int q = 0; q < 15; q++) {
                            ImageView block = imageViewsOfBlock[p][q];
                            double blockX = block.getLayoutX();
                            double blockY = block.getLayoutY();
                            double blockWidth = block.getBoundsInParent().getWidth();
                            double blockHeight = block.getBoundsInParent().getHeight();

                            // cannot be laid unless locating in block field
                            if (mouseX >= blockX && mouseX <= blockX + blockWidth &&
                                    mouseY >= blockY && mouseY <= blockY + blockHeight) {
                                letter[0][index] = Menu2.player[0].imageViewsOfLetter[index];
                                letter[0][index].setLayoutX(blockX);
                                letter[0][index].setLayoutY(blockY);
                                isMoving[index] = false;
                                movingImages[index] = null;
                                // load a letter mapped by an image to letter[][]
                                letter1[p][q] = scrabbleGame.imageCharacterHashMap.get(letter[0][index].getImage());
                                System.out.println("letter1[" + p + "][" + q + "] = " + letter1[p][q]);
                                System.out.println(letter[0][index].getImage());
                            }
                        }
                    }
                } else {
                    isMoving[index] = true;
                    movingImages[index] = Menu2.player[0].imageViewsOfLetter[index];
                }
            });
        }


        // 返回场景
        return sceneBoard;
    }
}



