import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        String wordToGuess = "java"; // Задайте слово, яке гравець повинен вгадати

        String playerGuess = scanner.next();

        if (playerGuess.equals(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
