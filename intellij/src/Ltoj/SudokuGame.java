package Ltoj;

/**
 * http://oj.leetcode.com/problems/valid-sudoku/
 * Created by jun on 14-2-26.
 */
public class SudokuGame {
    char board[][];
    boolean flag[][];
    static int width = 9;

    public void solveSudoku(char[][] board) {
        this.board = board;
        initFlags();

        width = board.length;
        int numOfCells = width * width;

        int index = 0;
        if (flag[0][0])
            board[0][0] = '1';

        while (index >= 0) {
            if (index == numOfCells-1){
                return;
            }

            if (expandable(index + 1)){
                index++;
                continue;
            }

            index = backTracing(index);
        }
    }

    public void initFlags() {
        flag = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[0].length; ++j) {
                if (board[i][j] == '.')
                    flag[i][j] = true;
            }
        }
    }

    int backTracing(int index) {
        do {
            int row = index/width;
            int col = index%width;

            while(!flag[row][col]){
                --index;
                row = index/width;
                col = index%width;
            }

            if (expandable(index))
                break;
            else
                --index;

        }while(index >= 0);

        return index;
    }

    boolean expandable(int index) {
        int row = index / width;
        int col = index % width;
        if (!flag[row][col])
            return true;

        char c = board[row][col];
        char a = (c == '.') ? '1' : (char)(c + 1);
        for(; a<='9'; ++a){
            board[row][col] = a;
            if (!validRow(row))
                continue;

            if (!validColumn(col))
                continue;

            int box = boxIndex(row, col);
            if (!validBox(box))
                continue;

            break;
        }

        boolean bRet = (a != '9' + 1);
        if (!bRet)
            board[row][col] = '.';

        return bRet;
    }

    int boxIndex(int row, int col){
        int y = row / 3;
        return y * 3 + col / 3;
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
