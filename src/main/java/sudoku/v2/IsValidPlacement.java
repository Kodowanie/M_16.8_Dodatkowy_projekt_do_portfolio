package sudoku.v2;

import javax.swing.*;

abstract public class IsValidPlacement{
    public static boolean isNumberInTheRow(JButton[][] board, int number, int row){
        String numberString = String.valueOf(number);
        for (int i = 0; i < SudokuButtons.GRID_SIZE; i++){
            if (board[row][i].getText().equals(numberString)){
                return true;
            }
        }
        return false;
    }
    public static boolean isNumberInTheColumn(JButton[][] board, int number, int column){
        String numberString = String.valueOf(number);
        for (int i = 0; i < SudokuButtons.GRID_SIZE; i++){
            if (board[i][column].getText().equals(numberString)){
                return true;
            }
        }
        return false;
    }
    public static boolean isNumberInTheBox(JButton[][] board, int number, int row, int column){
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        String numberString = String.valueOf(number);
        for (int r = boxRow; r < boxRow + 3; r++){
            for (int c = boxColumn; c < boxColumn + 3; c++){
                if (board[r][c].getText().equals(numberString)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isValid(JButton[][] board, int number, int row, int column){
        return !isNumberInTheRow(board, number, row) &&
                !isNumberInTheColumn(board, number, column) &&
                !isNumberInTheBox(board, number, row, column);
    }
}
