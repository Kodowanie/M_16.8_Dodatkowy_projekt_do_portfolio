package sudoku.v1;

import java.awt.*;

public class SudokuLayout {
    public void createSudokuLayout(Board board) {
        board.gameGrid.setLayout(new GridLayout(9,9,2,6));
        board.gameGrid.setBackground(Color.WHITE);
        board.gameGrid.setForeground(Color.WHITE);
        board.frame.add(board.gameGrid);
        }
}
