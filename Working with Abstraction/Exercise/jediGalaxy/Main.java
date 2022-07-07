package WorkingWithAbstractionExercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = readCoordinates(scanner.nextLine());

        int matrixRow = matrixDimensions[0];
        int matrixCol = matrixDimensions[1];

        int[][] matrix = new int[matrixRow][matrixCol];

        fillMatrix(matrixRow, matrixCol, matrix);

        String command = scanner.nextLine();

        long pointsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = readCoordinates(command);
            int[] evilCoordinates = readCoordinates(scanner.nextLine());

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            moveEvil(matrix, evilRow, evilCol);

            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];

            pointsCollected = moveJedi(matrix, pointsCollected, jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(pointsCollected);

    }

    private static int[] readCoordinates(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static long moveJedi(int[][] matrix, long sum, int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < matrix[1].length) {
            if (jediRow < matrix.length && jediCol >= 0 && jediCol < matrix[0].length) {
                sum += matrix[jediRow][jediCol];
            }
            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
