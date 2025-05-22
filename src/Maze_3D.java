import java.util.*;
import java.io.*;

public class Maze_3D {
    public static int[][][] moves = {
            {
                    {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}
            }
    };

    static int method(char[][][] maze, int startRow, int startCol, int startDepth) {
        boolean[][][] visited = new boolean[maze.length][maze[0].length][maze[0][0].length];
        visited[startRow][startCol][startDepth] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] check = {startRow, startCol, startDepth, 0}; // Add a counter for moves
        queue.add(check);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentMoves = current[3];

            for (int i = 0; i < 6; i++) {
                int r = current[0] + moves[0][i][0];
                int c = current[1] + moves[0][i][1];
                int d = current[2] + moves[0][i][2];
                if (r >= 0 && c >= 0 && d >= 0 && r < maze.length && c < maze[0].length && d < maze[0][0].length && !visited[r][c][d] && maze[r][c][d] != '#') {
                    if (maze[r][c][d] == 'E') {
                        return currentMoves + 1; // Return the number of moves taken to reach the exit
                    } else {
                        visited[r][c][d] = true;
                        int[] next = {r, c, d, currentMoves + 1};
                        queue.add(next);
                    }
                }
            }
        }
        return -1; // Return -1 if no exit is found
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr122.dat"));
        int numMazes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numMazes; i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int depth = scanner.nextInt();
            scanner.nextLine();

            char[][][] maze = new char[rows][cols][depth];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    maze[j][k] = scanner.nextLine().toCharArray();
                }
            }

            int startRow = 0;
            int startCol = 0;
            int startDepth = 0;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    for (int l = 0; l < depth; l++) {
                        if (maze[j][k][l] == 'S') {
                            startRow = j;
                            startCol = k;
                            startDepth = l;
                        }
                    }
                }
            }
            int moves = method(maze, startRow, startCol, startDepth);
            if (moves != -1) {
                System.out.println(moves);
            }
        }
    }
}