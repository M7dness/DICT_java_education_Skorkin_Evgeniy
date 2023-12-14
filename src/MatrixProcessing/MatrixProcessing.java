import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Your choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 4:
                    transposeMatrixMenu(scanner);
                    break;
                case 5:
                    calculateDeterminant(scanner);
                    break;
                case 6:
                    inverseMatrix(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }

    private static void addMatrices(Scanner scanner) {
        System.out.println("Enter size of first matrix: > ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        int[][] matrix1 = readMatrix(scanner, rows1, cols1);

        System.out.println("Enter size of second matrix: > ");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        int[][] matrix2 = readMatrix(scanner, rows2, cols2);

        if (canAddMatrices(rows1, cols1, rows2, cols2)) {
            int[][] resultMatrix = new int[rows1][cols1];
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols1; j++) {
                    resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Error: Matrices cannot be added. Please enter matrices with the same dimensions.");
        }
    }

    private static boolean canAddMatrices(int rows1, int cols1, int rows2, int cols2) {
        return rows1 == rows2 && cols1 == cols2;
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.println("Enter size of matrix: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, rows, cols);

        System.out.println("Enter constant: > ");
        int constant = scanner.nextInt();

        int[][] resultMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = constant * matrix[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    private static void multiplyMatrices(Scanner scanner) {
        // Ваша реалізація функції multiplyMatrices
    }

    private static void transposeMatrixMenu(Scanner scanner) {
        // Ваша реалізація функції transposeMatrixMenu
    }

    private static void calculateDeterminant(Scanner scanner) {
        // Ваша реалізація функції calculateDeterminant
    }

    private static void inverseMatrix(Scanner scanner) {
        // Ваша реалізація функції inverseMatrix
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        // Ваша реалізація функції readMatrix
    }

    private static void printMatrix(int[][] matrix) {
        // Ваша реалізація функції printMatrix
    }
}
