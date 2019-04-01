package model;

import java.util.Scanner;

public class GuessingGame {
    private final String EASY = "E";
    private final String HARD = "H";

    private String difficulty;
    private int upperLimit;
    private int number;
    private int lastGuess;
    private int guessesRemaining;

    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("\nWelcome to the number guessing game.");
        selectDifficulty();
        System.out.printf("\n%s %d %s%d", "You have", guessesRemaining,
                "chances to guess the magic number between 1 and", upperLimit);
        takeGuess();
    }

    public void selectDifficulty() {
        do {
            System.out.println("Please select difficulty:");
            System.out.printf("%s\n%s\n", "Easy (E)", "Hard (H)");
            difficulty = scanner.nextLine().toUpperCase();
        } while (!(difficulty.equals(EASY) || difficulty.equals(HARD))) ;
        setDifficulty();
    }

    private void setDifficulty() {
        if (difficulty.equals(EASY)) {
            number = (int) (Math.random()*10);
            upperLimit = 10;
            guessesRemaining = 3;
        } else if (difficulty.equals(HARD)) {
            number = (int) (Math.random()*100);
            upperLimit = 100;
            guessesRemaining = 5;
        }
    }

    private void takeGuess() {
        do {
            System.out.print("\nWhat is your guess? ");
            lastGuess = scanner.nextInt();
        } while (!checkGuess());
    }

    private boolean checkGuess() {
        boolean match = false;
        if (lastGuess == number) {
            match = true;
            System.out.println("You guessed the magic number!");
        } else if (lastGuess < number) {
            System.out.println("You guessed too low");
            guessesRemaining--;
            System.out.printf("%s %d\n", "Guesses remaining =", guessesRemaining);
        } else {
            System.out.println("You guessed too high");
            guessesRemaining--;
            System.out.printf("%s %d\n", "Guesses remaining =", guessesRemaining);
        }
        return match;
    }
}
