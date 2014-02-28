package Ltoj;

/**
 * http://oj.leetcode.com/problems/valid-sudoku/
 * Created by jun on 14-2-26.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!validRows(board))
            return false;

        if (!validColumns(board))
            return false;

        if (!validSubBoxes(board))
            return false;

        return true;
    }

    private boolean validSubBoxes(char[][] board) {
        char[] arr = new char[9];
        for (int boxIndex=0; boxIndex<9; ++boxIndex){
            for (int cellIndex=0; cellIndex<9; ++cellIndex){
                arr[cellIndex] = subBox(board, boxIndex, cellIndex);
            }

            if (!validArray(arr))
                return false;
        }
        return true;
    }

    private boolean validColumns(char[][] board) {
        char[] arr = new char[board.length];
        for (int i=0; i<board[0].length; ++i) {
            for(int j=0; j<board.length; ++j)
                arr[j] = board[j][i];

            if (!validArray(arr))
                return false;
        }
        return true;
    }

    private boolean validRows(char[][] board) {
        for (int i=0; i<board.length; ++i){
            if (!validArray(board[i]))
                return false;
        }
        return true;
    }

    public char subBox(char[][] board, int boxIndex, int cellIndex) {
        int row = boxIndex / 3;
        int col = boxIndex % 3;

        int y = 3 * row + cellIndex / 3;
        int x = 3 * col + cellIndex % 3;

        return board[y][x];
    }

    public static boolean validArray(char[] arr)
    {
        boolean flags[] = new boolean[9];
        for (char c: arr){
            if (c == '.')
                continue;

            int index = c - '1';
            if (flags[index] == true)
                return false;
            else
                flags[index] = true;
        }

        return true;
    }
}
