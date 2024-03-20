package com.example.demo1;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChessBlock {
    static double len = 45.0 / 1159 * 600;
    static double dis = 22.0 / 1159 * 600;
    FileInputStream fileInputStream;
    boolean isOccupied;

    Image image;
    ImageView imageViewOfBlock;

    static ChessBlock[][] chessBlock = new ChessBlock[15][15];

    public static Image getImage(){
        try {
            FileInputStream fileInputStream = new FileInputStream("out/letters/微信图片_202403141125571.jpg");
            BufferedImage bufferedImage = ImageIO.read(fileInputStream);
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void initializeChessBlocks() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                chessBlock[i][j] = new ChessBlock();
            }
        }
    }

    public ChessBlock() {
        image = ChessBlock.getImage();
        imageViewOfBlock = new ImageView(image);
        imageViewOfBlock.setFitHeight(20);
        imageViewOfBlock.setFitWidth(20);
        isOccupied = false;

        // Other initialization logic specific to each ChessBlock
    }
}
