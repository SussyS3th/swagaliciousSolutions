import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Puzzle {
    private static final int GRID_SIZE = 9;
    private static final int CELL_SIZE = 60;
    private static final int BOARD_SIZE = CELL_SIZE * GRID_SIZE;
    private static final Color CORRECT_COLOR = new Color(0, 128, 0); // Dark Green
    private static final Color INCORRECT_COLOR = new Color(139, 0, 0); // Dark Red
    private static final Color HIGHLIGHT_COLOR = new Color(255, 255, 0); // Yellow
    private static final Color SUBGRID_COLOR = new Color(105, 105, 105); // Dim Gray
    private static Color cellBackgroundColor = new Color(135, 206, 235); // Sky Blue
    private static Color presetBackgroundColor = new Color(70, 130, 180); // Steel Blue

    private static int[][] puzzle;
    private static final JTextField[][] cells = new JTextField[GRID_SIZE][GRID_SIZE];
    private static final SudokuSolver solver = new SudokuSolver();
    private static String difficulty = "medium";
    private static int hintCounter = 3;
    private static int colorSchemeIndex = 0;
    private static int pointCounter = 0;
    private static JLabel pointLabel;
    private static JLabel timerLabel;
    private static Timer timer;
    private static int secondsElapsed = 0;

    private static final Color[][] colorSchemes = {
            {new Color(47, 79, 79), new Color(25, 25, 112), Color.WHITE}, // Dark Slate Gray, Midnight Blue, White text
            {new Color(85, 107, 47), new Color(34, 34, 34), Color.WHITE},  // Dark Olive Green, Black, White text
            {new Color(0, 100, 0), new Color(0, 51, 102), Color.WHITE},  // Dark Green, Navy Blue, White text
            {new Color(128, 0, 0), new Color(0, 0, 128), Color.WHITE}, // Maroon, Navy, White text
            {new Color(47, 79, 79), new Color(139, 69, 19), Color.WHITE},  // Dark Slate Gray, Saddle Brown, White text
            {new Color(0, 128, 128), new Color(128, 0, 128), Color.WHITE},  // Teal, Purple, White text
            {new Color(128, 0, 128), new Color(0, 128, 0), Color.WHITE}, // Purple, Green, White text
            {new Color(184, 134, 11), new Color(0, 0, 0), Color.WHITE}  // Dark Goldenrod, Black, White text
    };

    private static void changeColorScheme(JPanel panel) {
        colorSchemeIndex = (colorSchemeIndex + 1) % colorSchemes.length;
        cellBackgroundColor = colorSchemes[colorSchemeIndex][0];
        presetBackgroundColor = colorSchemes[colorSchemeIndex][1];
        Color textColor = colorSchemes[colorSchemeIndex][2];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col].setForeground(textColor);
                if (puzzle[row][col] != 0) {
                    cells[row][col].setBackground(presetBackgroundColor);
                } else {
                    cells[row][col].setBackground(cellBackgroundColor);
                }
            }
        }
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(BOARD_SIZE + 200, BOARD_SIZE + 200); // Increased window size

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 2, 2));
        panel.setBackground(SUBGRID_COLOR);
        frame.add(panel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel difficultyLabel = new JLabel("Difficulty: " + difficulty);
        topPanel.add(difficultyLabel);

        pointLabel = new JLabel("Points: " + pointCounter);
        topPanel.add(pointLabel);

        timerLabel = new JLabel("Time: 00:00");
        topPanel.add(timerLabel);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton newPuzzleButton = new JButton("New Puzzle");
        JButton hintButton = new JButton("Hint (" + hintCounter + " left)"); // Declare hintButton here

        newPuzzleButton.addActionListener(e -> {
            generateNewPuzzle(panel, difficultyLabel);
            hintCounter = 3;
            pointCounter = 0;
            pointLabel.setText("Points: " + pointCounter);
            hintButton.setText("Hint (" + hintCounter + " left)");
            resetTimer();
        });
        buttonPanel.add(newPuzzleButton);

        hintButton.addActionListener(e -> {
            if (hintCounter > 0) {
                giveHint();
                hintCounter--;
                hintButton.setText("Hint (" + hintCounter + " left)");
            } else {
                JOptionPane.showMessageDialog(frame, "No hints left!");
            }
        });
        buttonPanel.add(hintButton);

        JButton colorSchemeButton = new JButton("Change Color Scheme");
        colorSchemeButton.addActionListener(e -> changeColorScheme(panel));
        buttonPanel.add(colorSchemeButton);

        String[] difficulties = {"Easy", "Medium", "Hard", "Expert", "Master"};
        JComboBox<String> difficultyComboBox = new JComboBox<>(difficulties);
        difficultyComboBox.setSelectedItem(difficulty);
        difficultyComboBox.addActionListener(e -> difficulty = (String) difficultyComboBox.getSelectedItem());
        buttonPanel.add(difficultyComboBox);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        generateNewPuzzle(panel, difficultyLabel);
        frame.setVisible(true);
    }

    private static void generateNewPuzzle(JPanel panel, JLabel difficultyLabel) {
        panel.removeAll();
        SudokuGenerator generator = new SudokuGenerator();
        puzzle = generator.generatePuzzle(difficulty.toLowerCase());
        difficultyLabel.setText("Difficulty: " + difficulty);

        for (int rowBlock = 0; rowBlock < 3; rowBlock++) {
            for (int colBlock = 0; colBlock < 3; colBlock++) {
                JPanel subgrid = new JPanel(new GridLayout(3, 3));
                subgrid.setBorder(BorderFactory.createLineBorder(SUBGRID_COLOR, 2));
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int actualRow = rowBlock * 3 + row;
                        int actualCol = colBlock * 3 + col;
                        cells[actualRow][actualCol] = new JTextField();
                        cells[actualRow][actualCol].setHorizontalAlignment(JTextField.CENTER);
                        cells[actualRow][actualCol].setFont(new Font("Arial", Font.BOLD, 20));
                        if (puzzle[actualRow][actualCol] != 0) {
                            cells[actualRow][actualCol].setText(String.valueOf(puzzle[actualRow][actualCol]));
                            cells[actualRow][actualCol].setEditable(false);
                            cells[actualRow][actualCol].setBackground(presetBackgroundColor);
                        } else {
                            cells[actualRow][actualCol].setBackground(cellBackgroundColor);
                            cells[actualRow][actualCol].setEditable(true);
                            cells[actualRow][actualCol].addActionListener(new CellActionListener(actualRow, actualCol));
                            cells[actualRow][actualCol].addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        handleEnterKey(actualRow, actualCol);
                                    } else {
                                        handleArrowKeys(e, actualRow, actualCol);
                                    }
                                }
                            });
                        }
                        subgrid.add(cells[actualRow][actualCol]);
                    }
                }
                panel.add(subgrid);
            }
        }
        panel.revalidate();
        panel.repaint();
        startTimer();
    }

    private static void handleArrowKeys(KeyEvent e, int row, int col) {
        int newRow = row;
        int newCol = col;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> newRow = (row > 0) ? row - 1 : GRID_SIZE - 1;
            case KeyEvent.VK_DOWN -> newRow = (row < GRID_SIZE - 1) ? row + 1 : 0;
            case KeyEvent.VK_LEFT -> newCol = (col > 0) ? col - 1 : GRID_SIZE - 1;
            case KeyEvent.VK_RIGHT -> newCol = (col < GRID_SIZE - 1) ? col + 1 : 0;
        }
        cells[newRow][newCol].requestFocus();
    }

    private static boolean isSolved() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (puzzle[row][col] == 0 || !solver.isValidPlacement(puzzle, puzzle[row][col], row, col)) {
                    return false;
                }
            }
        }
        showWinScreen();
        return true;
    }

    private static void showWinScreen() {
        stopTimer();
        int option = JOptionPane.showOptionDialog(null, "Congratulations! You solved the puzzle!", "Puzzle Solved",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"New Puzzle", "Close"}, "New Puzzle");
        if (option == JOptionPane.YES_OPTION) {
            generateNewPuzzle((JPanel) cells[0][0].getParent().getParent(), (JLabel) ((JFrame) SwingUtilities.getWindowAncestor(cells[0][0])).getContentPane().getComponent(1));
        } else {
            System.exit(0);
        }
    }

    private static void highlightMatchingNumbers(int number) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (cells[row][col].getText().equals(String.valueOf(number))) {
                    cells[row][col].setBackground(HIGHLIGHT_COLOR);
                } else if (puzzle[row][col] == 0) {
                    cells[row][col].setBackground(cellBackgroundColor);
                } else {
                    cells[row][col].setBackground(presetBackgroundColor);
                }
            }
        }
    }

    private static void giveHint() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (puzzle[row][col] == 0) {
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        if (solver.isValidPlacement(puzzle, number, row, col)) {
                            cells[row][col].setText(String.valueOf(number));
                            cells[row][col].setForeground(CORRECT_COLOR);
                            puzzle[row][col] = number;
                            return;
                        }
                    }
                }
            }
        }
    }


    private static void handleEnterKey(int row, int col) {
        JTextField source = cells[row][col];
        String text = source.getText();
        if (text.matches("[1-9]")) {
            int number = Integer.parseInt(text);
            if (solver.isValidPlacement(puzzle, number, row, col)) {
                source.setBackground(CORRECT_COLOR);
                puzzle[row][col] = number;
                pointCounter += 10; // Increase points for correct answer
                if (isSolved()) {
                    showWinScreen();
                }
            } else {
                source.setBackground(INCORRECT_COLOR);
                pointCounter -= 5; // Decrease points for incorrect answer
            }
        } else {
            source.setBackground(INCORRECT_COLOR);
            pointCounter -= 5; // Decrease points for invalid input
        }
        pointLabel.setText("Points: " + pointCounter);
    }

    private static void startTimer() {
        timer = new Timer();
        secondsElapsed = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsElapsed++;
                int minutes = secondsElapsed / 60;
                int seconds = secondsElapsed % 60;
                timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
            }
        }, 1000, 1000);
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private static void resetTimer() {
        stopTimer();
        timerLabel.setText("Time: 00:00");
        startTimer();
    }

    private record CellActionListener(int row, int col) implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField) e.getSource();
            String text = source.getText();
            if (text.matches("[1-9]")) {
                int number = Integer.parseInt(text);
                highlightMatchingNumbers(number);
            }
        }
    }
}