package com.example.numbergame.NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	private static final int RANGE_START = 1;
	private static final int RANGE_END = 100;
	private static final int MAX_ATTEMPTS = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean playAgain;
		int rounds = 0;
		int totalAttempts = 0;
		int roundsWon = 0;

		do {
			rounds++; // Increment round counter
			int correctNumber = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START; // Generate random number
			int attempts = 0; // Attempts counter for the current round
			boolean correctGuess = false; // Variable to track if the correct number is guessed

			System.out.println("Round " + rounds + ": Guess the number between " + RANGE_START + " and " + RANGE_END);

			// Loop to allow the user to guess the number
			while (attempts < MAX_ATTEMPTS && !correctGuess) {
				System.out.print("Enter your guess: ");
				int userGuess = scanner.nextInt();
				attempts++; // Increment the number of attempts

				// Provide feedback on the guess
				if (userGuess < correctNumber) {
					System.out.println("Too low!");
				} else if (userGuess > correctNumber) {
					System.out.println("Too high!");
				} else {
					System.out.println("Correct!");
					correctGuess = true; // Correct guess, exit the loop
					roundsWon++; // Increment rounds won counter
				}
			}

			// If the user fails to guess within the allowed attempts
			if (!correctGuess) {
				System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was "
						+ correctNumber + ".");
			}

			totalAttempts += attempts; // Add the number of attempts in this round to the total

			// Ask the user if they want to play another round
			System.out.print("Do you want to play another round? (y/n): ");
			playAgain = scanner.next().equalsIgnoreCase("y");
		} while (playAgain); // Continue if the user wants to play again

		// Display the game summary
		System.out
				.println("Game over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
		System.out.println("You won " + roundsWon + " rounds.");
		// Display scores
		System.out.println("Your score based on attempts: " + totalAttempts);
		System.out.println("Your score based on rounds won: " + roundsWon);

		scanner.close(); // Close the scanner
	}

}
