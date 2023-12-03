package sudoku.v1;

import javax.swing.*;
import java.awt.*;

public class SudokuButtons {
    final static int GRID_SIZE = 9;
    static JButton[][] gameLayout9x9 = new JButton[9][9];
    public void addButtonsToGrid(Board board){
        for (int r = 0; r < GRID_SIZE; r++){
            for (int c = 0; c < GRID_SIZE; c++){
                gameLayout9x9[r][c] = new JButton();
                board.gameGrid.add(gameLayout9x9[r][c]);
                gameLayout9x9[r][c].setFont(new Font("Arial Black", Font.PLAIN, 80));
                gameLayout9x9[r][c].setFocusable(true);
                gameLayout9x9[r][c].addActionListener(board);
            }
        }
    }
}
