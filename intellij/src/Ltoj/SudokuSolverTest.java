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
    @Before
    public void setUp() throws Exception {
        SudokuSolver game = new SudokuSolver();
    }

    @Ignore
    @Test
    public void testSolveSudoku() throws Exception {

    }

    @Test
    public void testNextPermutationInit() throws Exception {
        char[] row = {'5', '6', '.', '8', '4', '7', '.', '.', '.'};
        SudokuSolver.nextPermutation(row);
        int offset = SudokuSolver.offset;
        char[] ret = {'5', '6', (char)('1' + offset), '8', '4', '7',
                      (char)('2'+offset),
                      (char)('3'+offset),
                      (char)('9'+offset)};

        assertArrayEquals(ret, row);
    }

    @Ignore
    @Test
    public void testNextPermutationSecond() throws Exception {
        char[] row = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '3'+10, '9'+10};
        SudokuSolver.nextPermutation(row);
        char[] ret = {'5', '6', '1'+10, '8', '4', '7', '2'+10, '9'+10, '3'+10};
        assertArrayEquals(ret, row);
    }
}