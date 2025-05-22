import java.util. *;
import java.io. *;

public class shortestPath {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int method(char[][] maze, int startRow, int startCol) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[startRow][startCol] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] check = {startRow, startCol, 0}; // Add a counter for moves
        queue.add(check);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentMoves = current[2];


            for (int i = 0; i < 4; i++) {
                int r = current[0] + moves[i][0];
                int c = current[1] + moves[i][1];
                if (r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && !visited[r][c] && maze[r][c] != '#') {
                    if (maze[r][c] == 'E') {
                        return currentMoves + 1;
                    }
                    else {
                        visited[r][c] = true;
                        int[] next = {r, c, currentMoves + 1};
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr120.dat"));
        int numMazes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numMazes; i++) {
            int rs = scanner.nextInt();
            int cs = scanner.nextInt();
            scanner.nextLine();

            char[][] maze = new char[rs][cs];
            for (int j = 0; j < rs; j++) {maze[j] = scanner.nextLine().toCharArray();}

            int startRow = 0;
            int startCol = 0;
loop:
            for (int j = 0; j < rs; j++) {
                for (int k = 0; k < cs; k++) {
                    if (maze[j][k] == 'S') {
                        startRow = j;
                        startCol = k;
                        break loop;
                    }
                }
            }
            int moves = method(maze, startRow, startCol);
            System.out.println(moves);
        }

    }
}
