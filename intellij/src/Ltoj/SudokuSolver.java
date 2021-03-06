package ltoj;

import java.util.*;

/**
 * Created by jun on 14-2-28.
 */
public class SudokuSolver {
    char[][] board = null;
    final static int offset = 10;
    PermutationPro permutation = new PermutationPro();
    int currentRow = 0;

    public void solveSudoku(char[][] board) {
        currentRow = 0;
        permutation.setArray(board[currentRow]);
        permutation.next();

        while (currentRow > 0) {
            if (currentRow == 9 ) {
                // Get the right answers
                return;
            }

            permutation.setArray(board[currentRow+1]);

            // Find the next row
            boolean bGetNextRow = false;
            permutation.turnToNotFilled();
            while(!permutation.isLast()) {
                permutation.next();
                if(isValid()){
                   bGetNextRow = true;
                   ++currentRow;
                   break;
                }
            }

            if (bGetNextRow)
                continue;

            backTracing();
        }
    }

    private void backTracing(){
        do {
            permutation.setArray(board[currentRow]);
            permutation.turnToNotFilled();

            --currentRow;
            permutation.setArray(board[currentRow]);
            while(!permutation.isLast()){
                permutation.next();
                if (isValid()){
                    return;
                }
            }
        } while(currentRow > 0);
    }

    private boolean isValid(){
        return true;
    }

    static class Permutation {
        char [] arr;

        public void setArray(char[] arr){
            this.arr = arr;
        }

        public char[] next() {
            int i = indexToDecrease();
            if (i != 0) {
                swapWithSmallestBiggerValue(i);
            }

            Arrays.sort(arr, i, arr.length);
            return arr;
        }

        public boolean isLast() {
            return indexToDecrease() == 0;
        }

        private void swapWithSmallestBiggerValue(int i) {
            int j = i + 1;
            while(j < arr.length && arr[j] > arr[i-1])
                ++j;
            --j;

            char temp = arr[i-1];
            arr[i-1] = arr[j];
            arr[j] = temp;
        }

        private int indexToDecrease() {
            int i = arr.length - 1;
            while(i > 0 && arr[i-1] >= arr[i])
                --i;

            return i;
        }
    };

    static class PermutationPro {
        char [] arr;
        Permutation per = new Permutation();

        public void setArray(char[] arr){
            this.arr = arr;
        }

        private int getFilledCount() {
            int nCount = 0;
            for(char c: arr) {
                if (c >= '1' && c <= '9') {
                    ++nCount;
                }
            }
            return nCount;
        }

        public boolean notFilled(){
            for(char c: arr){
                if (c == '.')
                    return true;
            }

            return false;
        }

        public void turnToNotFilled(){
            for (int i=0; i<arr.length; ++i){
                if (arr[i] > '9')
                    arr[i] = '.';
            }
        }

        public boolean isLast(){
            int nCount = getFilledCount();
            nCount = 9 - nCount;

            char[] arrNum = new char[nCount];
            int j = 0;
            for (char c: arr){
                if (c > '9') {
                    arrNum[j++] = c;
                }
            }

            per.setArray(arrNum);
            return per.isLast();
        }

        public char[] next() {
            char[] numbers = getFillNumbers();
            fill(numbers);
            return arr;
        }

        private char[] getFillNumbers() {
            if (notFilled()) {
                return getInitialFillNumbers();
            }

            int nCount = 9 - getFilledCount();
            char arrRet[] = new char[nCount];

            int j = 0;
            for(char c: arr) {
                if (c > '9')
                    arrRet[j++] = c;
            }

            per.setArray(arrRet);
            arrRet = per.next();
            return arrRet;
        }

        private char[] getInitialFillNumbers() {
            int nCount = 9 - getFilledCount();
            char arrRet[] = new char[nCount];
            boolean flags[] = new boolean[9];

            int i = 0;
            for(char c: arr) {
                if (c >= '1' && c <= '9') {
                    flags[c - '1'] = true;
                }
            }

            int j = 0;
            for (i=0; i<9; ++i){
                if (!flags[i])
                    arrRet[j++] = (char)('1' + i + offset);
            }

            return arrRet;
        }

        private void fill(char[] numbers) {
            int i = 0;
            for(int j=0; j<9; ++j){
                if (arr[j] < '1' || arr[j] > '9'){
                    arr[j] = (char)(numbers[i++]);
                }
            }
        }
    };
}
