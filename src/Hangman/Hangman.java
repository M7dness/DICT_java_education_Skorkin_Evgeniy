import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("HANGMAN");

        while (playAgain) {
            String[] wordList = {"python", "java", "javascript", "kotlin"};
            String wordToGuess = wordList[random.nextInt(wordList.length)];
            int remainingLives = 8;
            StringBuilder guessedWord = new StringBuilder(wordToGuess.length());

            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedWord.append('-');
            }

            System.out.println("Type 'play' to play the game, 'exit' to quit: > ");
            String choice = scanner.next();

            if (choice.equals("play")) {
                System.out.println(guessedWord);

                char[] guessedLetters = new char[26];
                int guessedLetterCount = 0;

                while (remainingLives > 0) {
                    System.out.print("Input a letter: > ");
                    String input = scanner.next();

                    if (input.equals("exit")) {
                        playAgain = false;
                        break;
                    }

                    if (input.length() != 1 || !Character.isLowerCase(input.charAt(0))) {
                        System.out.println("Please enter a lowercase English letter");
                        continue;
                    }

                    char guess = input.charAt(0);

                    if (guessedLetters[guess - 'a'] == guess) {
                        System.out.println("You've already guessed this letter");
                        continue;
                    }

                    boolean letterFound = false;
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == guess) {
                            guessedWord.setCharAt(i, guess);
                            letterFound = true;
                        }
                    }

                    if (!letterFound) {
                        remainingLives--;
                        System.out.println("That letter doesn't appear in the word");
                    }

                    guessedLetters[guess - 'a'] = guess;
                    guessedLetterCount++;

                    System.out.println(guessedWord);

                    if (guessedWord.toString().equals(wordToGuess)) {
                        System.out.println("You guessed the word " + wordToGuess + "!");
                        System.out.println("You survived!");
                        break;
                    }
                }

                if (remainingLives == 0) {
                    System.out.println("You lost!");
                }
            } else if (choice.equals("exit")) {
                playAgain = false;
            } else {
                System.out.println("Invalid choice. Please enter 'play' to play the game or 'exit' to quit.");
            }
        }
    }
}
