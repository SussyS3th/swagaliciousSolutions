public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("elijah.dat"));
    int inputs = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < inputs; i++) {
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        sc.nextLine();
        for (int j = 0; j < row; j++) {
            String line = sc.nextLine();
            for (int k = 0; k < col; k++) {
                grid[j][k] = line.charAt(k);
            }
        }
        int turns = sc.nextInt() / 90; // num rotations
        for (int j = 0; j < turns; j++) {
            grid = rotateArray(grid);
        }
        printMatrix(grid);
    }
}

public static char[][] rotateArray(char[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    char[][] newArray = new char[cols][rows];
    for (int i = 0; i < cols; i++) {
        for (int j = 0; j < rows; j++) {
            newArray[i][j] = arr[rows - 1 - j][i];
        }
    }
    return newArray;
}
public static void printMatrix(char[][] matrix) {
    for (char[] row : matrix) {
        System.out.println(new String(row));
    }
}