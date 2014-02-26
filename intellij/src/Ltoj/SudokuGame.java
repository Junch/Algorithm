package Ltoj;

/**
 * http://oj.leetcode.com/problems/valid-sudoku/
 * Created by jun on 14-2-26.
 */
public class SudokuGame {
    public char[][] board  = null;

    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    public char subBox(int boxIndex, int cellIndex){
        int row = boxIndex / 3;
        int col = boxIndex % 3;

        int y = 3 * row + cellIndex / 3;
        int x = 3 * col + cellIndex % 3;

        return board[y][x];
    }
}
