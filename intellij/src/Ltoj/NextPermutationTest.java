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
        int[] a = {1, 2, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{1, 3, 2}, a);
    }

    @Test
    public void testNextPermutation2() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = {4, 5, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{5, 3, 4}, a);
    }

    @Test
    public void testNextPermutation3() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = {5, 4, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{3, 4, 5}, a);
    }

    @Test
    public void testNextPermutation4() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = {3, 5, 4, 2};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{4, 2, 3, 5}, a);
    }

    @Test
    public void testNextPermutation5() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = {5, 1, 1};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{1, 1, 5}, a);
    }
}
