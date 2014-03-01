package Ltoj;

import java.util.ArrayList;

/**
 * Created by jun on 14-2-28.
 */
public class SudokuSolver {
    char[][] board = null;
    final static int offset = 10;

    public void solveSudoku(char[][] board) {
        this.board = board;
    }

    public static void nextPermutation(char[] row) {
        char[] arr = getFillNumbers(row);
        fillNumbers(row, arr);
    }

    private static void fillNumbers(char[] row, char[] arr) {
        int i = 0;
        for(int j=0; j<9; ++j){
            if (row[j] == '.'){
                row[j] = (char)(arr[i++] + offset);
            }
        }
    }

    private static boolean firstTime(final char[] row){
        for(char c: row){
            if (c == '.')
                return true;
        }

        return false;
    }

    private static char[] getFillNumbers(final char[] row) {
        boolean bFirst = firstTime(row);
        int nCount = 9 - getFilledCount(row);
        char[] arr = null;

        if (bFirst) {
            arr = getInitialFillNumbers(row, nCount);
        }else {
            arr = new char[nCount];

            int j = 0;
            for(char c: row) {
                if (c > '9')
                    arr[j++] = (char)(c - offset);
            }
        }

        return arr;
    }

    private static void nextPermutate(char[] arr){
    }

    private static char[] getInitialFillNumbers(final char[] row, int nCount) {
        char arr[] = new char[nCount];
        boolean flags[] = new boolean[9];

        int i = 0;
        for(char c: row) {
            if (c >= '1' && c <= '9') {
                flags[c - '1'] = true;
            }
        }

        int j = 0;
        for (i=0; i<9; ++i){
            if (!flags[i])
                arr[j++] = (char)('1' + i);
        }

        return arr;
    }

    private static int getFilledCount(final char[] row) {
        int nCount = 0;
        for(char c: row) {
            if (c >= '1' && c <= '9') {
                ++nCount;
            }
        }
        return nCount;
    }
}
