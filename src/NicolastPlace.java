import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class NicolastPlace {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String[] directions = {"S", "N", "E", "W"}; // south, north, east, west

    static String method(char[][] maze, int startRow, int startCol) {
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        vis[startRow][startCol] = true;
        Queue<int[]> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        int[] check = {startRow, startCol};
        queue.add(check);
        pathQueue.add("");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            String path = pathQueue.poll();

            for (int i = 0; i < 4; i++) {
                int r = current[0];
                int c = current[1];
                StringBuilder newPath = new StringBuilder(path);
                boolean moved = false;
                while (true) {
                    r += moves[i][0];
                    c += moves[i][1];
                    if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == '#' || vis[r][c]) {
                        break;
                    }
                    if (!moved) {
                        newPath.append(directions[i]);
                        moved = true;
                    }
                    if (maze[r][c] == 'E') {
                        return newPath.toString();
                    }
                    if (!vis[r][c]) {
                        vis[r][c] = true;
                        queue.add(new int[]{r, c});
                        pathQueue.add(newPath.toString());
                    }
                }
            }
        }
        return "NO EXIT";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("nicolas.dat"));
        int nu = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nu; i++) {
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
            String result = method(maze, startRow, startCol);
            System.out.println(result);
        }
    }
}