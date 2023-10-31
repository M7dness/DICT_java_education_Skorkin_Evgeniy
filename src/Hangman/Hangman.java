import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] wordList = {"python", "java", "javascript", "kotlin"};
        String wordToGuess = wordList[random.nextInt(wordList.length)];
        int remainingLives = 8;
        StringBuilder guessedWord = new StringBuilder(wordToGuess.length());

        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord.append('-');
        }

        System.out.println("HANGMAN");
        System.out.println(guessedWord);

        while (remainingLives > 0) {
            System.out.print("Input a letter: > ");
            char guess = scanner.next().charAt(0);

            boolean letterFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    if (guessedWord.charAt(i) != guess) {
                        guessedWord.setCharAt(i, guess);
                        letterFound = true;
                    } else {
                        System.out.println("No improvements");
                    }
                }
            }

            if (!letterFound) {
                remainingLives--;
                System.out.println("That letter doesn't appear in the word");
            }

            System.out.println(guessedWord);

            if (guessedWord.toString().equals(wordToGuess)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (remainingLives == 0) {
            System.out.println("You lost!");
        }
    }
}
