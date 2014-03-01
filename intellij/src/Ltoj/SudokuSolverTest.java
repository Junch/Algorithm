package Ltoj;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jun on 14-2-28.
 */
public class SudokuSolverTest {
    SudokuSolver game;
    SudokuSolver.PermutationPro perPro;

    @Before
    public void setUp() throws Exception {
        game = new SudokuSolver();
        perPro = new SudokuSolver.PermutationPro();
    }

    @Ignore
    @Test
    public void testSolveSudoku() throws Exception {

    }

    @Test
    public void testNextPermutationInit() throws Exception {
        char[] row = {'5', '6', '.', '8', '4', '7', '.', '.', '.'};
        perPro.setArray(row);

        int offset = SudokuSolver.offset;
        char[] ret = {'5', '6', (char)('1' + offset), '8', '4', '7',
                (char)('2'+offset),
                (char)('3'+offset),
                (char)('9'+offset)};

        assertArrayEquals(ret, perPro.next());
    }

    @Test
    public void testNextPermutationSecond() throws Exception {
        char[] row = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '3'+10, '9'+10};
        perPro.setArray(row);
        assertEquals(false, perPro.isLast());

        perPro.next();
        char[] ret = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '9'+10, '3'+10};
        assertArrayEquals(ret, row);
    }

    @Test
    public void testTurnToUnFilled() throws Exception {
        char[] row = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '3'+10, '9'+10};
        perPro.setArray(row);
        perPro.turnToNotFilled();

        char[] ret = {'5', '6', '.', '8', '4', '7', '.', '.', '.'};
        assertArrayEquals(ret, row);
    }

    @Test
    public void testNextPermutationBiggestOne() throws Exception {
        char[] row = {'5', '6', '9'+10, '8', '4', '7', '3'+10, '2'+10, '1'+10};
        perPro.setArray(row);
        assertEquals(true, perPro.isLast());

        perPro.next();
        char[] ret = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '3'+10, '9'+10};
        assertArrayEquals(ret, row);
    }

    @Test
    public void testNextPermutate() throws Exception {
        char[] a = {'5', '3', '4'};
        SudokuSolver.Permutation per = new SudokuSolver.Permutation();
        per.setArray(a);
        assertEquals(false, per.isLast());
        assertArrayEquals(new char[]{'5', '4', '3'}, per.next());
    }

    @Test
    public void testNextPermutateNext() throws Exception {
        char[] a = {'5', '4', '3'};
        SudokuSolver.Permutation per = new SudokuSolver.Permutation();
        per.setArray(a);
        assertEquals(true, per.isLast());
        assertArrayEquals(new char[]{'3', '4', '5'}, per.next());
    }
}
