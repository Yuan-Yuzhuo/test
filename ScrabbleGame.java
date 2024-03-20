package com.example.demo1;

import javafx.scene.image.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.io.IOException;

// This class contains image and scores of each letter

public class ScrabbleGame {
    private static HashMap<Character,Integer> letterScores;
    public static Image getImage(char letter) {
        try {
            String fileName = getFileNameForLetter(letter);
            String filePath = "out/letters/" + fileName; // adjust the postfix practically, then get the whole path
            FileInputStream fis = new FileInputStream(new File(filePath)); // get InputStream using the path
            //BufferedImage bufferedImage = ImageIO.read(fis); // receive the InputStream, and get a BufferImage
            return new Image(fis); // convert BufferImage to image
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFileNameForLetter(char letter) {
        // return respective postfix depending on the letter
        switch (Character.toUpperCase(letter)) {
            case 'A':
                return "微信图片_20240314112424.jpg";
            case 'B':
                return "微信图片_20240314112547.jpg";
            case 'C':
                return "微信图片_202403141125471.jpg";
            case 'D':
                return "微信图片_202403141125472.jpg";
            case 'E':
                return "微信图片_20240314112548.jpg";
            case 'F':
                return "微信图片_202403141125481.jpg";
            case 'G':
                return "微信图片_202403141125482.jpg";
            case 'H':
                return "微信图片_20240314112549.jpg";
            case 'I':
                return "微信图片_202403141125491.jpg";
            case 'J':
                return "微信图片_202403141125492.jpg";
            case 'K':
                return "微信图片_20240314112550.jpg";
            case 'L':
                return "微信图片_202403141125501.jpg";
            case 'M':
                return "微信图片_20240314112551.jpg";
            case 'N':
                return "微信图片_202403141125511.jpg";
            case 'O':
                return "微信图片_20240314112552.jpg";
            case 'P':
                return "微信图片_202403141125521.jpg";
            case 'Q':
                return "微信图片_20240314112553.jpg";
            case 'R':
                return "微信图片_202403141125531.jpg";
            case 'S':
                return "微信图片_202403141125532.jpg";
            case 'T':
                return "微信图片_20240314112554.jpg";
            case 'U':
                return "微信图片_202403141125541.jpg";
            case 'V':
                return "微信图片_20240314112555.jpg";
            case 'W':
                return "微信图片_202403141125551.jpg";
            case 'X':
                return "微信图片_20240314112556.jpg";
            case 'Y':
                return "微信图片_202403141125561.jpg";
            case 'Z':
                return "微信图片_20240314112557.jpg";
            default:
                return "";
        }
    }

    public HashMap<Image,String> imageCharacterHashMap = new HashMap<>();

    // add the map of image and letter
    public void initializeImageCharacterHashMap(){
        for (char c = 'A'; c <= 'Z'; c++) {
            imageCharacterHashMap.put(getImage(c), Character.toString(c));
        }
    }


    public ScrabbleGame() {
        initializeLetterScores();
        initializeImageCharacterHashMap();
    }



    public void initializeLetterScores(){
        letterScores = new HashMap<>(); // contain each letter and its scores
        letterScores.put('A',1);
        letterScores.put('B',3);
        letterScores.put('C',3);
        letterScores.put('D',2);
        letterScores.put('E',1);
        letterScores.put('F',4);
        letterScores.put('G',2);
        letterScores.put('H',4);
        letterScores.put('I',1);
        letterScores.put('J',8);
        letterScores.put('K',5);
        letterScores.put('L',1);
        letterScores.put('M',3);
        letterScores.put('O',1);
        letterScores.put('P',3);
        letterScores.put('Q',10);
        letterScores.put('R',1);
        letterScores.put('S',1);
        letterScores.put('T',1);
        letterScores.put('U',1);
        letterScores.put('V',4);
        letterScores.put('W',4);
        letterScores.put('X',8);
        letterScores.put('Y',4);
        letterScores.put('Z',10);
    }
    public int getScore(char letter){
        Integer score = letterScores.get(letter);
        if (score!=null)
            return score;
        else
            return 0;
    }

}
