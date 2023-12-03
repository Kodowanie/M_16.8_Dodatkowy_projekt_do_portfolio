package sudoku.v2;

import sudoku.v2.abstraction.ISudokuSolver;

import javax.swing.*;
import java.awt.*;

public class SudokuSolver implements ISudokuSolver {
    @Override
    public boolean solveBoard(JButton[][] boardJButtons) {
            for (int r = 0; r < SudokuButtons.GRID_SIZE; r++) {
                for (int c = 0; c < SudokuButtons.GRID_SIZE; c++) {
                    if (boardJButtons[r][c].getText().equals("")) {
                        for (int tryNumber = 1; tryNumber <= SudokuButtons.GRID_SIZE; tryNumber++) {
                            if (IsValidPlacement.isValid(boardJButtons, tryNumber, r, c)) {
                                String stringTryNumber = String.valueOf(tryNumber);
                                boardJButtons[r][c].setText(stringTryNumber);
                                boardJButtons[r][c].setBackground(Color.ORANGE);
                                if (solveBoard(boardJButtons)){
                                    return true;
                                } else {
                                    boardJButtons[r][c].setText("");
                                    boardJButtons[r][c].setBackground(Color.YELLOW);
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