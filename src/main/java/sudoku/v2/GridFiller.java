package sudoku.v2;

import sudoku.v1.IsValidPlacement;
import sudoku.v2.abstraction.IGridFiller;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static sudoku.v2.Board.gameDifficultyLevel;

public class GridFiller implements IGridFiller {
    Random random = new Random();
    @Override
    public void fillGridWithRandomNumbers(){
        for (int i = 0;  i < 10 ; i++){
            int randomRow = random.nextInt(SudokuButtons.GRID_SIZE);
            int randomColumn = random.nextInt(SudokuButtons.GRID_SIZE);
            int randomNumber = random.nextInt(1, SudokuButtons.GRID_SIZE+1);
            String randomNumberText = String.valueOf(randomNumber);
            if (SudokuButtons.gameLayout9x9[randomRow][randomColumn].getText()==""){
                if (IsValidPlacement.isValid(SudokuButtons.gameLayout9x9, randomNumber, randomRow, randomColumn)){
                    SudokuButtons.gameLayout9x9[randomRow][randomColumn].setText(randomNumberText);
                    SudokuButtons.gameLayout9x9[randomRow][randomColumn].setBackground(Color.RED);
                } else {
                    i--;
                }
            } else {
                i--;
            }
        }
        validGameBoardCreation(SudokuButtons.gameLayout9x9);
    }
    public boolean validGameBoardCreation(JButton[][] boardJButtons) {
        for (int r = 0; r < SudokuButtons.GRID_SIZE; r++) {
            for (int c = 0; c < SudokuButtons.GRID_SIZE; c++) {
                if (boardJButtons[r][c].getText().equals("")) {
                    for (int tryNumber = 1; tryNumber <= SudokuButtons.GRID_SIZE; tryNumber++) {
                        if (sudoku.v2.IsValidPlacement.isValid(boardJButtons, tryNumber, r, c)) {
                            String stringTryNumber = String.valueOf(tryNumber);
                            boardJButtons[r][c].setText(stringTryNumber);
                            boardJButtons[r][c].setBackground(Color.RED);
                            if (validGameBoardCreation(boardJButtons)){
                                return true;
                            } else {
                                boardJButtons[r][c].setText("");
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void removeNumbersFromValidGameBoard(JButton[][] boardJButtons){
        for (int i = 0; i <= gameDifficultyLevel; i++){
            int randomRow = random.nextInt(SudokuButtons.GRID_SIZE);
            int randomColumn = random.nextInt(SudokuButtons.GRID_SIZE);
            if (boardJButtons[randomRow][randomColumn].getText()!=""){
                boardJButtons[randomRow][randomColumn].setText("");
                boardJButtons[randomRow][randomColumn].setBackground(Color.WHITE);
            } else {
                i--;
            }
        }
    }

}
