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
    }

    @Test
    public void testSubBox() throws Exception {
        for (int i=0; i<3; ++i)
            for (int j=0; j<3; ++j)
                game.board[i][j] = '0';
    }
}
