import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Portal {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Point {
        int row, col, steps;

        Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    static int findShortestPath(char[][] maze, int startRow, int startCol, int endRow, int endCol, Map<Character, List<Point>> portals) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.row == endRow && current.col == endCol) {
                return current.steps;
            }

            for (int[] move : moves) {
                int newRow = current.row + move[0];
                int newCol = current.col + move[1];

                if (newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && maze[newRow][newCol] != '#') {
                    visited[newRow][newCol] = true;
                    queue.add(new Point(newRow, newCol, current.steps + 1));
                }
            }

            if (Character.isDigit(maze[current.row][current.col])) {
                char portal = maze[current.row][current.col];
                for (Point portalPoint : portals.get(portal)) {
                    if (portalPoint.row != current.row || portalPoint.col != current.col) {
                        if (!visited[portalPoint.row][portalPoint.col]) {
                            visited[portalPoint.row][portalPoint.col] = true;
                            queue.add(new Point(portalPoint.row, portalPoint.col, current.steps));
                        }
                    }
                }
            }
        }
        return -1; // Should never reach here as the maze is guaranteed to be solvable
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr121.dat"));
        int numMazes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numMazes; i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();

            char[][] maze = new char[rows][cols];
            Map<Character, List<Point>> portals = new HashMap<>();
            int startRow = 0, startCol = 0, endRow = 0, endCol = 0;

            for (int j = 0; j < rows; j++) {
                maze[j] = scanner.nextLine().toCharArray();
                for (int k = 0; k < cols; k++) {
                    char cell = maze[j][k];
                    if (cell == 'S') {
                        startRow = j;
                        startCol = k;
                    } else if (cell == 'E') {
                        endRow = j;
                        endCol = k;
                    } else if (Character.isDigit(cell)) {
                        portals.putIfAbsent(cell, new ArrayList<>());
                        portals.get(cell).add(new Point(j, k, 0));
                    }
                }
            }

            int shortestPath = findShortestPath(maze, startRow, startCol, endRow, endCol, portals);
            System.out.println(shortestPath);
        }
    }
}