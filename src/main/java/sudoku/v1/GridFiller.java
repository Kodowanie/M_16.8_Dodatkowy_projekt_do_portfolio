package sudoku.v1;

import java.awt.*;
import java.util.Random;

import static sudoku.v1.SudokuButtons.GRID_SIZE;

public class GridFiller {
    Random random = new Random();
    SudokuSolver ss = new SudokuSolver();
    public void fillGridWithRandomNumbers(){
            for (int i = 0;  i < 81 ; i++){
                int randomRow = random.nextInt(GRID_SIZE);
                int randomColumn = random.nextInt(GRID_SIZE);
                int randomNumber = random.nextInt(1,GRID_SIZE+1);
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
    }
}
