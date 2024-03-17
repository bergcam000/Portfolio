// Cameron Berg
// Class: CS&141
// Date 7/20/23
// Lab 4
// Purpose: This program is designed to play number a guessing game with the user.

import java.util.Scanner;

public class Guess {
    // Constant for the max number used in guessing game
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGuesses = Integer.MAX_VALUE;

        introduceGame();

        // Main game loop
        String playAgain;
        do {
            int answer = generateRandomNumber();
            int guesses = playOneGame(scanner, answer);
            totalGames++;
            totalGuesses += guesses;
            bestGuesses = Math.min(bestGuesses, guesses);

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next();
        } while (playAgain.startsWith("y") || playAgain.startsWith("Y"));

        scanner.close();

        reportResults(totalGames, totalGuesses, bestGuesses);
    }

    // Runs the intro text

    private static void introduceGame() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER);
        System.out.println("Try to guess it.");
    }

    // Picks a random number between 1 and MAX_NUMBER

    private static int generateRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER) + 1;
    }
    
    // Plays the game once

    private static int playOneGame(Scanner scanner, int answer) {
        int guess;
        int numGuesses = 0;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numGuesses++;

            if (guess < answer) {
                System.out.println("The answer is higher.");
            } else if (guess > answer) {
                System.out.println("The answer is lower.");
            } else {
                if (numGuesses == 1) {
                    System.out.println("You got it right in 1 guess!");
                } else {
                    System.out.println("You got it right in " + numGuesses + " guesses!");
                }
            }
        } while (guess != answer);

        return numGuesses;
    }
    
    // Reports the final stats of your games

    private static void reportResults(int totalGames, int totalGuesses, int bestGuesses) {
        double averageGuesses = (double) totalGuesses / totalGames;

        System.out.println("Overall Results:");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total guesses made: " + totalGuesses);
        System.out.printf("Average guesses per game: %.1f%n", averageGuesses);
        System.out.println("Best (fewest) number of guesses: " + bestGuesses);
    }
}
