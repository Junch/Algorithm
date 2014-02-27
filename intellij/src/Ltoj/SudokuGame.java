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

    final static class Point {
        Point(int xTag, int yTag){
            x = xTag;
            y = yTag;
        }
        int x;
        int y;
    }

    public static Point board2SubBox(Point pnt) {
        Point boxPnt = new Point(0, 0);

        int row = pnt.y / 3;
        boxPnt.x = row * 3 + pnt.x / 3;

        row = pnt.y % 3;
        boxPnt.y = row * 3 + pnt.x % 3;

        return boxPnt;
    }

    public static Point subBox2Board(Point pntBox) {
        Point pnt = new Point(0, 0);

        int row = pntBox.x / 3;
        int col = pntBox.x % 3;

        pnt.y = row * 3 + pntBox.y / 3;
        pnt.x = col * 3 + pntBox.y % 3;

        return pnt;
    }

    public static char[] nextPermutation(char[] s)
    {
        return s;
    }
}
