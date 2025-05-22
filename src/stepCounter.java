import java.util.*;
import java.io.*;

public class stepCounter {
    public static void printGrid(char[][] grid, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int countSteps(char[][] grid, int r, int c) {
        boolean[][] visited = new boolean[r][c];
        int startRow = 0;
        for (int i = 0; i < r; i++) {
            if (grid[i][0] == '.') {
                startRow = i;
                grid[i][0] = '*';
                break;
            }
        }
        visited[startRow][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, 0});
        int steps = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (y == c - 1) {
                return steps;
            }
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX >= 0 && newY >= 0 && newX < r && newY < c && !visited[newX][newY] && grid[newX][newY] == '.') {
                    visited[newX][newY] = true;
                    grid[newX][newY] = '*';
                    queue.add(new int[]{newX, newY});
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr93.dat"));
        int dataSets = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < dataSets; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            char[][] grid = new char[r][c];

            for (int j = 0; j < r; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < c; k++) {
                    grid[j][k] = line.charAt(k);
                }
            }

            int steps = countSteps(grid, r, c);
            if (steps == -1) {
                System.out.println("No valid path found.");
            } else {
                printGrid(grid, r, c);
                System.out.println("PATH IS OF LENGTH " + (steps + 1));
            }
            System.out.println();
        }
    }
}