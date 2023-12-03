package sudoku.v2.abstraction;

import javax.swing.*;

public interface IGridFiller {
    void fillGridWithRandomNumbers();
    public boolean validGameBoardCreation(JButton[][] boardJButtons);
    public void removeNumbersFromValidGameBoard(JButton[][] boardJButtons);
}
