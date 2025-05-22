import java.util.*;

class BoardState {
    public char[][] actualBoard = new char[8][8];
    public String[][] systemBoard = new String[8][8];
}

class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}

public class Chess {
    public static boolean inCheck;
    public static boolean checkmate;
    public static int whiteMaterial;
    public static int blackMaterial;

    public static void start(BoardState boardState) {
        // Initialize the board with white pieces at the bottom and black pieces at the top
        boardState.actualBoard[0] = new char[] {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'};
        boardState.actualBoard[7] = new char[] {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};
        for (int i = 0; i < 8; i++) {
            boardState.actualBoard[1][i] = 'p';
            boardState.actualBoard[6][i] = 'P';
        }
        for (int i = 2; i < 6; i++) {
            Arrays.fill(boardState.actualBoard[i], '.');
        }
        whiteMaterial = 39; // material count for white
        blackMaterial = 39; // material count for black
        updateSystemBoard(boardState);
    }

    private static void displayBoard(BoardState boardState, boolean[][] isSelected, List<int[]> possibleMoves) {
        for (int i = 0; i < boardState.actualBoard.length; i++) {
            for (int j = 0; j < boardState.actualBoard[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                boolean isMove = possibleMoves.stream().anyMatch(move -> move[0] == finalI && move[1] == finalJ);
                if (isSelected[i][j]) {
                    System.out.print(ConsoleColors.GREEN + boardState.actualBoard[i][j] + ConsoleColors.RESET + " ");
                } else if (isMove) {
                    System.out.print(ConsoleColors.RED + boardState.actualBoard[i][j] + ConsoleColors.RESET + " ");
                } else if (Character.isUpperCase(boardState.actualBoard[i][j])) {
                    System.out.print(ConsoleColors.WHITE + boardState.actualBoard[i][j] + ConsoleColors.RESET + " ");
                } else if (Character.isLowerCase(boardState.actualBoard[i][j])) {
                    System.out.print(ConsoleColors.BLACK + boardState.actualBoard[i][j] + ConsoleColors.RESET + " ");
                } else {
                    System.out.print(ConsoleColors.CYAN + boardState.actualBoard[i][j] + ConsoleColors.RESET + " ");
                }
            }
            System.out.print("   "); // Space between the boards
            for (int j = 0; j < boardState.systemBoard[i].length; j++) {
                System.out.print(boardState.systemBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void update(BoardState boardState, boolean[][] isSelected, int fromRow, int fromCol, int toRow, int toCol) {
        // Move the piece on the actual board
        char capturedPiece = boardState.actualBoard[toRow][toCol];
        boardState.actualBoard[toRow][toCol] = boardState.actualBoard[fromRow][fromCol];
        boardState.actualBoard[fromRow][fromCol] = '.';

        // Update material counters
        if (Character.isUpperCase(capturedPiece)) {
            blackMaterial -= getPieceValue(capturedPiece);
        } else if (Character.isLowerCase(capturedPiece)) {
            whiteMaterial -= getPieceValue(capturedPiece);
        }

        // Check for pawn promotion
        if (boardState.actualBoard[toRow][toCol] == 'P' && toRow == 0) {
            boardState.actualBoard[toRow][toCol] = promotePawn('P');
        } else if (boardState.actualBoard[toRow][toCol] == 'p' && toRow == 7) {
            boardState.actualBoard[toRow][toCol] = promotePawn('p');
        }

        // Update the system board to show coordinates
        updateSystemBoard(boardState);
    }

    private static void updateSystemBoard(BoardState boardState) {
        for (int i = 0; i < boardState.systemBoard.length; i++) {
            for (int j = 0; j < boardState.systemBoard[i].length; j++) {
                boardState.systemBoard[i][j] = (char)('a' + j) + Integer.toString(8 - i);
            }
        }
    }

    private static char promotePawn(char pawn) {
        Scanner sc = new Scanner(System.in);
        char promotion;
        while (true) {
            System.out.println("Promote pawn to (Q, R, B, N): ");
            promotion = sc.next().charAt(0);
            promotion = Character.toUpperCase(promotion);
            if (promotion == 'Q' || promotion == 'R' || promotion == 'B' || promotion == 'N') {
                break;
            } else {
                System.out.println("Invalid choice. Please choose Q, R, B, or N.");
            }
        }
        if (Character.isLowerCase(pawn)) {
            promotion = Character.toLowerCase(promotion);
        }
        return promotion;
    }

    private static int getPieceValue(char piece) {
        return switch (Character.toUpperCase(piece)) {
            case 'P' -> 1;
            case 'N', 'B' -> 3;
            case 'R' -> 5;
            case 'Q' -> 9;
            default -> 0;
        };
    }

    private static List<int[]> getPossibleMoves(char[][] board, int row, int col, char piece) {
        List<int[]> moves = new ArrayList<>();
        boolean isWhite = Character.isUpperCase(piece);

        switch (Character.toUpperCase(piece)) {
            case 'P':
                // Pawn moves
                if (isWhite) {
                    if (row > 0 && board[row - 1][col] == '.') {
                        moves.add(new int[]{row - 1, col});
                        if (row == 6 && board[row - 2][col] == '.') {
                            moves.add(new int[]{row - 2, col});
                        }
                    }
                    if (row > 0 && col > 0 && Character.isLowerCase(board[row - 1][col - 1])) {
                        moves.add(new int[]{row - 1, col - 1});
                    }
                    if (row > 0 && col < 7 && Character.isLowerCase(board[row - 1][col + 1])) {
                        moves.add(new int[]{row - 1, col + 1});
                    }
                } else {
                    if (row < 7 && board[row + 1][col] == '.') {
                        moves.add(new int[]{row + 1, col});
                        if (row == 1 && board[row + 2][col] == '.') {
                            moves.add(new int[]{row + 2, col});
                        }
                    }
                    if (row < 7 && col > 0 && Character.isUpperCase(board[row + 1][col - 1])) {
                        moves.add(new int[]{row + 1, col - 1});
                    }
                    if (row < 7 && col < 7 && Character.isUpperCase(board[row + 1][col + 1])) {
                        moves.add(new int[]{row + 1, col + 1});
                    }
                }
                break;
            case 'R':
                // Rook moves
                for (int i = row - 1; i >= 0; i--) {
                    if (board[i][col] == '.') {
                        moves.add(new int[]{i, col});
                    } else {
                        if (Character.isUpperCase(board[i][col]) != isWhite) {
                            moves.add(new int[]{i, col});
                        }
                        break;
                    }
                }
                for (int i = row + 1; i < 8; i++) {
                    if (board[i][col] == '.') {
                        moves.add(new int[]{i, col});
                    } else {
                        if (Character.isUpperCase(board[i][col]) != isWhite) {
                            moves.add(new int[]{i, col});
                        }
                        break;
                    }
                }
                for (int i = col - 1; i >= 0; i--) {
                    if (board[row][i] == '.') {
                        moves.add(new int[]{row, i});
                    } else {
                        if (Character.isUpperCase(board[row][i]) != isWhite) {
                            moves.add(new int[]{row, i});
                        }
                        break;
                    }
                }
                for (int i = col + 1; i < 8; i++) {
                    if (board[row][i] == '.') {
                        moves.add(new int[]{row, i});
                    } else {
                        if (Character.isUpperCase(board[row][i]) != isWhite) {
                            moves.add(new int[]{row, i});
                        }
                        break;
                    }
                }
                break;
            case 'N':
                // Knight moves
                int[][] knightMoves = {
                        {row - 2, col - 1}, {row - 2, col + 1}, {row - 1, col - 2}, {row - 1, col + 2},
                        {row + 1, col - 2}, {row + 1, col + 2}, {row + 2, col - 1}, {row + 2, col + 1}
                };
                for (int[] move : knightMoves) {
                    int r = move[0], c = move[1];
                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && (board[r][c] == '.' || Character.isUpperCase(board[r][c]) != isWhite)) {
                        moves.add(new int[]{r, c});
                    }
                }
                break;
            case 'B':
                // Bishop moves
                for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
                    if (board[row - i][col - i] == '.') {
                        moves.add(new int[]{row - i, col - i});
                    } else {
                        if (Character.isUpperCase(board[row - i][col - i]) != isWhite) {
                            moves.add(new int[]{row - i, col - i});
                        }
                        break;
                    }
                }
                for (int i = 1; row - i >= 0 && col + i < 8; i++) {
                    if (board[row - i][col + i] == '.') {
                        moves.add(new int[]{row - i, col + i});
                    } else {
                        if (Character.isUpperCase(board[row - i][col + i]) != isWhite) {
                            moves.add(new int[]{row - i, col + i});
                        }
                        break;
                    }
                }
                for (int i = 1; row + i < 8 && col - i >= 0; i++) {
                    if (board[row + i][col - i] == '.') {
                        moves.add(new int[]{row + i, col - i});
                    } else {
                        if (Character.isUpperCase(board[row + i][col - i]) != isWhite) {
                            moves.add(new int[]{row + i, col - i});
                        }
                        break;
                    }
                }
                for (int i = 1; row + i < 8 && col + i < 8; i++) {
                    if (board[row + i][col + i] == '.') {
                        moves.add(new int[]{row + i, col + i});
                    } else {
                        if (Character.isUpperCase(board[row + i][col + i]) != isWhite) {
                            moves.add(new int[]{row + i, col + i});
                        }
                        break;
                    }
                }
                break;
            case 'Q':
                // Queen moves (combination of Rook and Bishop)
                moves.addAll(getPossibleMoves(board, row, col, 'R'));
                moves.addAll(getPossibleMoves(board, row, col, 'B'));
                break;
            case 'K':
                // King moves
                int[][] kingMoves = {
                        {row - 1, col - 1}, {row - 1, col}, {row - 1, col + 1},
                        {row, col - 1}, {row, col + 1},
                        {row + 1, col - 1}, {row + 1, col}, {row + 1, col + 1}
                };
                for (int[] move : kingMoves) {
                    int r = move[0], c = move[1];
                    if (r >= 0 && r < 8 && c >= 0 && c < 8 && (board[r][c] == '.' || Character.isUpperCase(board[r][c]) != isWhite)) {
                        moves.add(new int[]{r, c});
                    }
                }
                break;
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardState boardState = new BoardState();
        boolean[][] isSelected = new boolean[8][8];

        start(boardState);
        System.out.println("Welcome to chess! \n How many minutes would you like your game to last?");
        int gameLength = sc.nextInt(); // will convert from minutes to seconds
        int gameTime = gameLength * 60;
        long whiteTimeLeft = gameTime * 1000L;
        long blackTimeLeft = gameTime * 1000L;
        boolean whiteTurn = true; // White starts first

        while (whiteTimeLeft > 0 && blackTimeLeft > 0) {
            long turnStartTime = System.currentTimeMillis();
            System.out.println("Time left - White: " + whiteTimeLeft / 1000 + " seconds, Black: " + blackTimeLeft / 1000 + " seconds");
            System.out.println("Material - White: " + whiteMaterial + ", Black: " + blackMaterial);
            List<int[]> possibleMoves = new ArrayList<>();
            displayBoard(boardState, isSelected, possibleMoves);

            int fromRow, fromCol;
            while (true) {
                System.out.println("Enter the coordinates of the piece you want to move: ");
                String from = sc.next();
                fromRow = 8 - Character.getNumericValue(from.charAt(1));
                fromCol = from.charAt(0) - 'a';

                // Check if the selected square has a piece
                if (boardState.actualBoard[fromRow][fromCol] == '.') {
                    System.out.println("No piece at the selected coordinates. Please select again.");
                    continue; // Ask for input again
                }

                // Check if the piece belongs to the current player
                if ((whiteTurn && Character.isLowerCase(boardState.actualBoard[fromRow][fromCol])) ||
                        (!whiteTurn && Character.isUpperCase(boardState.actualBoard[fromRow][fromCol]))) {
                    System.out.println("You cannot select your opponent's piece. Please select again.");
                    continue; // Ask for input again
                }

                isSelected[fromRow][fromCol] = true;
                break; // Exit the loop if a valid piece is selected
            }

            // Highlight possible moves
            possibleMoves = getPossibleMoves(boardState.actualBoard, fromRow, fromCol, boardState.actualBoard[fromRow][fromCol]);

            // Check for pinned pieces
            if (isPiecePinned(boardState, fromRow, fromCol, whiteTurn)) {
                System.out.println("This piece is pinned and cannot be moved.");
                isSelected[fromRow][fromCol] = false;
                continue;
            }

            displayBoard(boardState, isSelected, possibleMoves);
            System.out.println("Enter the coordinates of where you want to move the piece: ");
            String to = sc.next();
            int toRow = 8 - Character.getNumericValue(to.charAt(1));
            int toCol = to.charAt(0) - 'a';

            // Check if the move is valid
            if (possibleMoves.stream().noneMatch(move -> move[0] == toRow && move[1] == toCol)) {
                System.out.println("Invalid move. Try again.");
                isSelected[fromRow][fromCol] = false;
                continue;
            }

            // Check if the move exposes the king to check
            if (wouldExposeKingToCheck(boardState, fromRow, fromCol, toRow, toCol, whiteTurn)) {
                System.out.println("This move would expose your king to check. Try again.");
                isSelected[fromRow][fromCol] = false;
                continue;
            }

            update(boardState, isSelected, fromRow, fromCol, toRow, toCol);
            isSelected[fromRow][fromCol] = false;

            // Check for inCheck and checkmate conditions
            inCheck = checkForCheck(boardState.actualBoard, whiteTurn);
            checkmate = checkForCheckmate(boardState.actualBoard, whiteTurn);

            if (checkmate) {
                if (whiteTurn) {
                    System.out.println("Checkmate! Black wins. White loses.");
                } else {
                    System.out.println("Checkmate! White wins. Black loses.");
                }
                break;
            } else if (inCheck) {
                System.out.println("Check!");
            }

            long turnEndTime = System.currentTimeMillis();
            long turnDuration = turnEndTime - turnStartTime;

            if (whiteTurn) {
                whiteTimeLeft -= turnDuration;
            } else {
                blackTimeLeft -= turnDuration;
            }

            // Switch turns without flipping the board
            whiteTurn = !whiteTurn; // Switch turns
        }

        if (whiteTimeLeft <= 0) {
            System.out.println("Black wins on time!");
        } else if (blackTimeLeft <= 0) {
            System.out.println("White wins on time!");
        }
    }

    private static boolean isPiecePinned(BoardState boardState, int row, int col, boolean whiteTurn) {
        char piece = boardState.actualBoard[row][col];
        char king = whiteTurn ? 'K' : 'k';
        int kingRow = -1, kingCol = -1;

        // Find the king's position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardState.actualBoard[i][j] == king) {
                    kingRow = i;
                    kingCol = j;
                    break;
                }
            }
        }

        // Check for pins in all directions
        // Check vertical and horizontal
        for (int i = 0; i < 8; i++) {
            if (i != row && boardState.actualBoard[i][col] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[i][col]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
            }
            if (i != col && boardState.actualBoard[row][i] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[row][i]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
            }
        }

        // Check diagonals
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (boardState.actualBoard[row - i][col - i] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[row - i][col - i]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
                break; // Stop checking further in this direction
            }
        }
        for (int i = 1; row - i >= 0 && col + i < 8; i++) {
            if (boardState.actualBoard[row - i][col + i] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[row - i][col + i]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
                break; // Stop checking further in this direction
            }
        }
        for (int i = 1; row + i < 8 && col - i >= 0; i++) {
            if (boardState.actualBoard[row + i][col - i] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[row + i][col - i]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
                break; // Stop checking further in this direction
            }
        }
        for (int i = 1; row + i < 8 && col + i < 8; i++) {
            if (boardState.actualBoard[row + i][col + i] != '.') {
                if (Character.isUpperCase(boardState.actualBoard[row + i][col + i]) != whiteTurn) {
                    // Check if the path to the king is clear
                    if (isPathClear(boardState.actualBoard, row, col, kingRow, kingCol)) {
                        return true; // The piece is pinned
                    }
                }
                break; // Stop checking further in this direction
            }
        }

        return false; // The piece is not pinned
    }

    private static boolean isPathClear(char[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        int rowDirection = Integer.compare(toRow, fromRow);
        int colDirection = Integer.compare(toCol, fromCol);
        int currentRow = fromRow + rowDirection;
        int currentCol = fromCol + colDirection;

        while (currentRow != toRow || currentCol != toCol) {
            if (board[currentRow][currentCol] != '.') {
                return false; // Path is blocked
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }
        return true; // Path is clear
    }

    private static boolean wouldExposeKingToCheck(BoardState boardState, int fromRow, int fromCol, int toRow, int toCol, boolean whiteTurn) {
        // Make a hypothetical move
        char piece = boardState.actualBoard[fromRow][fromCol];
        char targetPiece = boardState.actualBoard[toRow][toCol];
        boardState.actualBoard[toRow][toCol] = piece;
        boardState.actualBoard[fromRow][fromCol] = '.';

        // Check if the king is in check after the move
        boolean inCheckAfterMove = checkForCheck(boardState.actualBoard, whiteTurn);

        // Undo the hypothetical move
        boardState.actualBoard[fromRow][fromCol] = piece;
        boardState.actualBoard[toRow][toCol] = targetPiece;

        return inCheckAfterMove; // Return true if the king would be in check
    }

    private static boolean checkForCheck(char[][] board, boolean whiteTurn) {
        int kingRow = -1, kingCol = -1;
        char king = whiteTurn ? 'K' : 'k';

        // Find the king's position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == king) {
                    kingRow = i;
                    kingCol = j;
                    break;
                }
            }
        }

        // Check if any opponent piece can move to the king's position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.isUpperCase(board[i][j]) != whiteTurn) {
                    List<int[]> moves = getPossibleMoves(board, i, j, board[i][j]);
                    for (int[] move : moves) {
                        if (move[0] == kingRow && move[1] == kingCol) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkForCheckmate(char[][] board, boolean whiteTurn) {
        // Try all possible moves to see if any move can get the player out of check
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Character.isUpperCase(board[i][j]) == whiteTurn) {
                    List<int[]> moves = getPossibleMoves(board, i, j, board[i][j]);
                    for (int[] move : moves) {
                        char[][] boardCopy = copyBoard(board);
                        boardCopy[move[0]][move[1]] = boardCopy[i][j];
                        boardCopy[i][j] = '.';
                        if (!checkForCheck(boardCopy, whiteTurn)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static char[][] copyBoard(char[][] board) {
        char[][] copy = new char[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 8);
        }
        return copy;
    }
}