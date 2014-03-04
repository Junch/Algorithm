package ltoj;

/**
 * http://oj.leetcode.com/problems/valid-sudoku/
 * Created by jun on 14-2-26.
 */
public class ValidSudoku {
    char board[][];

    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        for (int i=0; i<9; ++i){
            if (!validRow(i))
                return false;
            if (!validColumn(i))
                return false;
            if(!validBox(i))
                return false;
        }

        return true;
    }

    private boolean validRow(int row) {
        return validArray(board[row]);
    }

    private boolean validColumn(int col){
        char arr[] = new char[board.length];

        for(int i=0; i<board.length; ++i)
            arr[i] = board[i][col];

        return validArray(arr);
    }

    private boolean validBox(int box) {
        char arr[] = new char[9];

        for (int cellIndex=0; cellIndex<9; ++cellIndex)
            arr[cellIndex] = subBox(box, cellIndex);

        return validArray(arr);
    }

    public char subBox(int boxIndex, int cellIndex) {
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
