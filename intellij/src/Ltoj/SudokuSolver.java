package Ltoj;

import java.util.*;

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

    public static boolean isLastPermutatation(final char[] num) {
        int nCount = getFilledCount(num);
        nCount = 9 - nCount;

        char[] arr = new char[nCount];
        int j = 0;
        for (char c: num){
            if (c > '9') {
                arr[j++] = c;
            }
        }

        return isLastPermutate(arr);
    }

    private static void fillNumbers(char[] row, char[] arr) {
        int i = 0;
        for(int j=0; j<9; ++j){
            if (row[j] < '1' || row[j] > '9'){
                row[j] = (char)(arr[i++]);
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
                    arr[j++] = c;
            }

            nextPermutate(arr);
        }

        return arr;
    }

    public static void nextPermutate(char[] num) {
        int i = indexToDecrease(num);
        if (i != 0) {
            swapWithSmallestBiggerValue(num, i);
        }

        Arrays.sort(num, i, num.length);
    }

    private static void swapWithSmallestBiggerValue(char[] num, int i) {
        int j = i + 1;
        while(j < num.length && num[j] > num[i-1])
            ++j;
        --j;

        char temp = num[i-1];
        num[i-1] = num[j];
        num[j] = temp;
    }

    private static int indexToDecrease(char[] num) {
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i])
            --i;

        return i;
    }

    public static boolean isLastPermutate(char[] num){
        return indexToDecrease(num) == 0;
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
                arr[j++] = (char)('1' + i + offset);
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
