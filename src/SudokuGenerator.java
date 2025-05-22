import java.util.HashSet;
import java.util.*;
import java.io.*;

class SudokuGenerator {
    private static final int GRID_SIZE = 9;
    private final SudokuSolver solver = new SudokuSolver();

    public int[][] generatePuzzle(String difficulty) {
        int[][] board = new int[GRID_SIZE][GRID_SIZE];
        fillDiagonalBoxes(board);
        fillRemaining(board, 0, 3);
        removeNumbers(board, difficulty);
        return board;
    }

    private void fillDiagonalBoxes(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i += 3) {
            fillBox(board, i, i);
        }
    }

    private void fillBox(int[][] board, int row, int col) {
        Set<Integer> usedNumbers = new HashSet<>();
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(9) + 1;
                } while (usedNumbers.contains(num));
                usedNumbers.add(num);
                board[row + i][col + j] = num;
            }
        }
    }

    private boolean fillRemaining(int[][] board, int i, int j) {
        if (j >= GRID_SIZE && i < GRID_SIZE - 1) {
            i++;
            j = 0;
        }
        if (i >= GRID_SIZE && j >= GRID_SIZE) {
            return true;
        }
        if (i < 3) {
            if (j < 3) {
                j = 3;
            }
        } else if (i < GRID_SIZE - 3) {
            if (j == (i / 3) * 3) {
                j += 3;
            }
        } else {
            if (j == GRID_SIZE - 3) {
                i++;
                j = 0;
                if (i >= GRID_SIZE) {
                    return true;
                }
            }
        }
        for (int num = 1; num <= GRID_SIZE; num++) {
            if (solver.isValidPlacement(board, num, i, j)) {
                board[i][j] = num;
                if (fillRemaining(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }

    private void removeNumbers(int[][] board, String difficulty) {
        int count = switch (difficulty.toLowerCase()) {
            case "easy" -> 40;
            case "medium" -> 45;
            case "hard" -> 50;
            case "expert" -> 55;
            case "master" -> 60;
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
        Random rand = new Random();
        while (count != 0) {
            int cellId = rand.nextInt(GRID_SIZE * GRID_SIZE);
            int i = cellId / GRID_SIZE;
            int j = cellId % GRID_SIZE;
            if (board[i][j] != 0) {
                board[i][j] = 0;
                count--;
            }
        }
    }
}