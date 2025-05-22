import java.util.*;
import java.io.*;

public class Arcade {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static char[][] rotateMaze(char[][] maze) {
        int n = maze.length;
        char[][] rotated = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = maze[i][j];
            }
        }
        return rotated;
    }

    static int method(char[][] maze, int startRow, int startCol, int t) {
        int n = maze.length;
        boolean[][] visited = new boolean[n][n]; // Visited without rotation tracking
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0}); // {row, col, steps}

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                int currentSteps = current[2];

                if (currentSteps > t) {
                    return -1; // Total Knockout
                }

                if (maze[currentRow][currentCol] == 'E') {
                    return currentSteps; // Escaped the Arcade
                }

                // Try moving in all four directions
                for (int[] move : moves) {
                    int r = currentRow + move[0];
                    int c = currentCol + move[1];

                    if (r >= 0 && c >= 0 && r < n && c < n && maze[r][c] != 'J' && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.add(new int[]{r, c, currentSteps + 1});
                    }
                }
            }
            // Rotate the maze after processing all moves for this second
            maze = rotateMaze(maze);
        }
        return -1; // No exit found
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("arcade.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int t = sc.nextInt();
            sc.nextLine();

            char[][] maze = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                maze[i] = sc.nextLine().toCharArray();
            }

            int startRow = 0;
            int startCol = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (maze[i][j] == 'S') {
                        startRow = i;
                        startCol = j;
                    }
                }
            }
            int moves = method(maze, startRow, startCol, t);
            if (moves != -1) {
                System.out.println("Escaped the Arcade in " + moves + " steps.");
            } else {
                System.out.println("Total Knockout.");
            }
        }
    }
}