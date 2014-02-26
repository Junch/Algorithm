package Ltoj;

import org.junit.Before;
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
        game.board = new char[9][9];

        for (int i=0; i<9; ++i)
            for (int j=0; j<9; ++j)
                game.board[i][j] = '0';
    }

    @Test
    public void testSubBox() throws Exception {
        game.board[1][3] = '*';
        assertEquals('*', game.subBox(1, 3));

        game.board[6][7] = '8';
        assertEquals('8', game.subBox(8, 1));
    }
}
