import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class JumpMaze {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {2, 0}, {-2, 0}, {0, 2}, {0, -2}};

    static boolean method(char[][] maze, int startRow, int startCol) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[startRow][startCol] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int r = current[0] + moves[i][0];
                int c = current[1] + moves[i][1];
                if (r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && !visited[r][c] && maze[r][c] != 'X') {
                    if (maze[r][c] == 'E') {
                        return true;
                    } else {
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr94.dat"));
        int numMazes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numMazes; i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();

            char[][] maze = new char[rows][cols];
            for (int j = 0; j < rows; j++) {
                maze[j] = scanner.nextLine().toCharArray();
            }

            int startRow = 0;
            int startCol = 0;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (maze[j][k] == 'S') {
                        startRow = j;
                        startCol = k;
                    }
                }
            }
            if (method(maze, startRow, startCol)) {
                System.out.println("EXIT FOUND!");
            } else {
                System.out.println("NO EXIT FOUND!");
            }
        }
    }
}