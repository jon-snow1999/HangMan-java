package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    String greeting = "Hello there !!!..... and welcome to HangMan :)";
    System.out.println(greeting);
    String[] movies = {"the shawshank redemption",
            "the godfather", "the dark knight", "schindler's list", "pulp fiction",
            "the lord of the rings", "the good the bad and the ugly",
            "fight club", "the lord of the rings", "forrest gump", "star wars", "inception",
            "the lord of the rings", "the matrix", "samurai", "star wars", "city of god", "the silence of the lambs",
            "batman begins", "die hard", "chinatown", "room", "dunkirk", "fargo", "no country for old men" , "teen wolf" };
    // here the movie is randomly picked so it would pass as an argument to game constructor
    int randomMovie = (int) (Math.random()* movies.length);
    Game newGame = new Game(movies[randomMovie]);
    System.out.println("can you guess the following movie ? ");
    // now i'm calling the method which is responsible for the guessing process
    newGame.guessMovie();

    }
}
