package Ltoj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-2-27.
 */
public class NextPermutationTest {
    @Test
    public void testNextPermutation1() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = new int[]{1, 2, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{1, 3, 2}, a);
    }

    @Test
    public void testNextPermutation2() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = new int[]{4, 5, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{5, 3, 4}, a);
    }

    @Test
    public void testNextPermutation3() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = new int[]{5, 4, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{3, 4, 5}, a);
    }
}
