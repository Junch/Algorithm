package ltoj;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.lang.reflect.*;

/**
 * Created by jun on 14-2-26.
 */
public class NQueensTest {

    NQueens sln = null;

    private Method getConflictMethod() throws NoSuchMethodException {
        Class[] paras = {Stack.class, int.class, int.class};
        Method method = sln.getClass().getDeclaredMethod("conflict", paras);
        method.setAccessible(true);
        return method;
    }

    @Before
    public void setUp() throws Exception{
        sln = new NQueens();
    }

    @Test
    public void testSolveNQueens() throws Exception {
        ArrayList<String[]> arr = sln.solveNQueens(4);
        assertEquals(2, arr.size());

        String[] arr0 = { ".Q..", "...Q", "Q...", "..Q." };

        assertArrayEquals(arr0, arr.get(0));
    }

    @Test
    public void conflictWithSameRow() throws Exception {
        Method method = getConflictMethod();

        Stack<NQueens.Node> S = new Stack<NQueens.Node>();
        S.push(new NQueens.Node(1, 2));
        assertEquals(true, method.invoke(sln, S, 1, 3));
    }

    @Test
    public void conflictWithSameColumn() throws Exception {
        Method method = getConflictMethod();

        Stack<NQueens.Node> S = new Stack<NQueens.Node>();
        S.push(new NQueens.Node(1, 2));
        assertEquals(true, method.invoke(sln, S, 3, 2));
    }

    @Test
    public void conflictWithSlash() throws Exception {
        Method method = getConflictMethod();

        Stack<NQueens.Node> S = new Stack<NQueens.Node>();
        S.push(new NQueens.Node(1, 2));
        assertEquals(true, method.invoke(sln, S, 3, 0));
        assertEquals(true, method.invoke(sln, S, 3, 4));
    }
}
