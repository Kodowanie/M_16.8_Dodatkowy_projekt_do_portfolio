package sudoku.v1;

import javax.swing.*;
import java.awt.*;

public class SudokuSolver {
    public boolean solveBoard(JButton[][] board) {
//            try {
//                Thread.sleep(25);
//            } catch (InterruptedException ie) {
//                throw new RuntimeException(ie);
//            }
            for (int r = 0; r < SudokuButtons.GRID_SIZE; r++) {
                for (int c = 0; c < SudokuButtons.GRID_SIZE; c++) {
                    if (board[r][c].getText().equals("")) {
                        for (int tryNumber = 1; tryNumber <= SudokuButtons.GRID_SIZE; tryNumber++) {
                            if (IsValidPlacement.isValid(board, tryNumber, r, c)) {
                                String stringTryNumber = String.valueOf(tryNumber);
                                board[r][c].setText(stringTryNumber);
                                board[r][c].setBackground(Color.ORANGE);
                                if (solveBoard(board)){
                                    return true;
                                } else {
                                    board[r][c].setText("");
                                    board[r][c].setBackground(Color.YELLOW);
                                }
                            }
                        }
                        return false;
                    }
                }
            }
        return true;
    }
}