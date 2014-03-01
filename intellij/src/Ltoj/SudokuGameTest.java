package Ltoj;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-2-26.
 */
public class SudokuGameTest {
    SudokuGame game = null;

    @Before
    public void setUp() throws Exception {
        game = new SudokuGame();
    }

    @Test
    public void validArrayWithRepeatedNumber() throws Exception {
        char s[]= {'1', '1', '3'};
        assertEquals(false, ValidSudoku.validArray(s));
    }

    @Test
    public void validArrayWithUnfilledNumber() throws Exception {
        char s[]= {'1', '.', '3', '.'};
        assertEquals(true, ValidSudoku.validArray(s));
    }

    @Test
    public void validArrayWithUnfilledNumber2() throws Exception {
        char s[][]= {{'1', '.', '1', '.'},
                     {'1', '.', '3', '.'}};
        assertEquals(false, ValidSudoku.validArray(s[0]));
        assertEquals(true, ValidSudoku.validArray(s[1]));
    }

    @Test
    public void testSubBox() throws Exception {
        char board[][] = new char[9][9];
        game.board = board;

        board[1][3] = '*';
        assertEquals('*', game.subBox(1, 3));

        board[6][7] = '8';
        assertEquals('8', game.subBox(8, 1));
    }

    @Test
    public void testExpandable() throws Exception {
        char board[][]= {{'1', '3', '8'},
                         {'4', '9', '.'},
                         {'6', '7', '2'}};
        game.board = board;
        game.width = 3;
        game.initFlags();
        assertEquals(true, game.expandable(5));
        assertEquals('5', board[1][2]);
    }

    @Test
    public void testExpandable2() throws Exception {
        char board[][]= {{'1', '.', '8'},
                         {'4', '9', '.'},
                         {'6', '7', '2'}};
        game.board = board;
        game.width = 3;
        game.initFlags();
        board[0][1] = '3';
        assertEquals(true, game.expandable(1));
        assertEquals('5', board[0][1]);
    }

    @Test
    public void testboxIndex() throws Exception {
        int a = game.boxIndex(1, 4);
        assertEquals(1, a);
    }

    @Test
         public void testBackTracing() throws Exception {
        char board[][]= {{'1', '.', '8'},
                {'4', '9', '.'},
                {'6', '7', '2'}};
        game.board = board;
        game.width = 3;
        game.initFlags();
        board[0][1] = '3';
        assertEquals(1, game.backTracing(4));
        assertEquals('5', board[0][1]);
    }

    @Test
    public void testBackTracing2() throws Exception {
        char board[][]= {{'.', '3', '8'},
                         {'4', '9', '.'},
                         {'6', '7', '2'}};
        game.board = board;
        game.width = 3;
        game.initFlags();
        board[0][0] = '5';
        assertEquals(-1, game.backTracing(4));
        assertEquals('.', board[0][0]);
    }

    @Test
    public void solveSudoku() throws Exception {
        char board[][]= {{'1', '3', '.'},
                         {'4', '9', '.'},
                         {'6', '7', '2'}};

        game.solveSudoku(board);
        assertArrayEquals(new char[]{'1','3','5'}, board[0]);
        assertArrayEquals(new char[]{'4','9','8'}, board[1]);
    }
}
