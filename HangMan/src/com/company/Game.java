package com.company;

import java.util.Scanner;

public class Game {
    String wrongLetters = "";
    private String movieName;
    private int noOfGuesses = 10;
    private String hits = "";

    public Game(String movieName) {
        this.movieName = movieName;
        }

    public void guessMovie() {
        // now this block transforms the letters of the movie title into "_"
        StringBuilder display = new StringBuilder("");
        for (int i = 0; i < movieName.length(); i++) {
            display.append("_");
        }
        System.out.println(display);
        // this block here lowers the letters of the movie title
        String loweredCaseMovie = movieName.toLowerCase();
        char[] charactersArray = loweredCaseMovie.toCharArray();
        while (noOfGuesses > 0) {
            //this block of code reads the user input
            Scanner userLetter = new Scanner(System.in);
            String userInput = userLetter.nextLine().toLowerCase();
            char firstLetter = userInput.charAt(0);
            // this block checks if the user guessed a letter more than once
            if (wrongLetters.indexOf(firstLetter) != -1) {
                System.out.println("sorry you have guessed that letter before .... try again ");
                continue;
            }
            if (hits.indexOf(firstLetter) != -1){
                System.out.println("you have guessed that letter before ..... try again");
                continue;
            }
            // now this for loop iterates through the movie characters array to see if the user guessed right
            for (int i =0 ; i <movieName.length();i++ ) {
                if (firstLetter == charactersArray[i]) {
                    display.setCharAt(i, firstLetter);
                    hits = hits + firstLetter;
                    System.out.println(display);
                    }
            }
            // this if block checks if the user entered a wrong letter
            if (display.indexOf(String.valueOf(firstLetter)) == -1) {
                noOfGuesses = noOfGuesses - 1;
                wrongLetters = wrongLetters + firstLetter;
                System.out.println("sorry you guessed the wrong letter: " + firstLetter +
                        "\n" + " you still have " + noOfGuesses + " guesses left");
               // this block gives a hint
                if (noOfGuesses == 5){
                    int randomLetter = (int) Math.random()*movieName.length();
                    char hintLetter = movieName.charAt(randomLetter);
                    if (hits.indexOf(hintLetter) == -1){
                        System.out.println("you see i wil give you a hint .... one of the letters is: " + hintLetter);
                    }
                }
                continue;
            }
          // this code here changes the stringbuilder into a string .... to see if the user has won or not
            String theWord = display.toString();
            if (theWord.equals(movieName)) {
                System.out.println("yaaaaay congrats you won !!");
                break;
            }
            }
        if (noOfGuesses == 0) {
            System.out.println("sorry you have lost :( " + "the correct word was: " + movieName);
        }
    }
}



