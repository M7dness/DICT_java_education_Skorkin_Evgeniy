import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створюємо пусту ігрову сітку
        char[][] gameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Виводимо порожню ігрову сітку
        printGameBoard(gameBoard);

        // Головний ігровий цикл
        while (true) {
            // Хід першого гравця (Х)
            makeMove(gameBoard, 'X');
            printGameBoard(gameBoard);
            if (checkGameResult(gameBoard, 'X')) {
                break;
            }

            // Хід другого гравця (О)
            makeMove(gameBoard, 'O');
            printGameBoard(gameBoard);
            if (checkGameResult(gameBoard, 'O')) {
                break;
            }
        }

        // Закриваємо Scanner
        scanner.close();
    }

    // Функція для виведення ігрового поля
    public static void printGameBoard(char[][] board) {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    // Функція для здійснення ходу гравця
    public static void makeMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinatesInput = scanner.nextLine();

            try {
                // Перетворюємо введені координати в числа
                String[] coordinatesArray = coordinatesInput.split(" ");
                int row = Integer.parseInt(coordinatesArray[0]) - 1;
                int col = Integer.parseInt(coordinatesArray[1]) - 1;

                // Перевірка коректності введених координат
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                // Перевірка, чи клітинка не зайнята
                if (board[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                // Оновлення ігрового поля
                board[row][col] = player;
                break;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    // Функція для перевірки результату гри
    public static boolean checkGameResult(char[][] board, char player) {
        // Логіка перевірки результату гри (залишається без змін)

        // Приклад перевірки для виходу із циклу
        if (player == 'X') {
            System.out.println("X wins");
            return true;
        } else {
            System.out.println("O wins");
            return true;
        }
    }
}
