package ltoj;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-2-26.
 */
public class ValidSudokuTest {
    ValidSudoku game = null;

    @Before
    public void setUp() throws Exception {
        game = new ValidSudoku();
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
}
