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
        game.board = new char[9][9];

        for (int i=0; i<9; ++i)
            for (int j=0; j<9; ++j)
                game.board[i][j] = '0';
    }

    @Test
    public void testboard2SubBox() throws Exception {
        SudokuGame.Point pnt= new SudokuGame.Point(1, 8);
        SudokuGame.Point boxPnt = SudokuGame.board2SubBox(pnt);
        assertEquals(6, boxPnt.x);
        assertEquals(7, boxPnt.y);
    }

    @Test
    public void testSubBox2Board() throws Exception {
        SudokuGame.Point pnt= new SudokuGame.Point(6, 7);
        SudokuGame.Point boxPnt = SudokuGame.subBox2Board(pnt);
        assertEquals(1, boxPnt.x);
        assertEquals(8, boxPnt.y);
    }

    @Ignore
    @Test
    public void testNextPermutation() throws Exception {
        char [] a = new char[]{'1', '2', '3'};
        char [] b = SudokuGame.nextPermutation(a);
        assertArrayEquals(new char[]{'1', '3', '2'}, b);
    }
}
