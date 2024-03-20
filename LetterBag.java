package com.example.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterBag {

    protected static List<Character> letters;
    public LetterBag(){
        letters = new ArrayList<>();
        initializeLetterBag();
        shuffleLetters();
    }
    public void initializeLetterBag(){
        addLetters('A',9);
        addLetters('B',2);
        addLetters('C',2);
        addLetters('D',4);
        addLetters('E',12);
        addLetters('F',2);
        addLetters('G',3);
        addLetters('H',2);
        addLetters('I',9);
        addLetters('J',1);
        addLetters('K',1);
        addLetters('L',4);
        addLetters('M',2);
        addLetters('N',6);
        addLetters('O',8);
        addLetters('P',2);
        addLetters('Q',1);
        addLetters('R',6);
        addLetters('S',4);
        addLetters('T',6);
        addLetters('U',4);
        addLetters('V',2);
        addLetters('W',2);
        addLetters('X',1);
        addLetters('Y',2);
        addLetters('Z',1);
    }
    public void addLetters(char letter, int count){
        for(int i=0; i<count; i++){
            letters.add(letter); // add n same letters into the bag, n equals to the number of this letter
        }
    }
    public char drawLetter(){
        if(!letters.isEmpty())
            return letters.remove(0); // return a random letter and draw out it from the bag
        else
            return ' ';
    }
    public void shuffleLetters(){
        Collections.shuffle(letters); // make it random
    }
}
