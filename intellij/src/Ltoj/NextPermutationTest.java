package Ltoj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-2-27.
 */
public class NextPermutationTest {
    @Test
    public void testNextPermutation() throws Exception {
        NextPermutation sln = new NextPermutation();
        int[] a = new int[]{1, 2, 3};
        sln.nextPermutation(a);
        assertArrayEquals(new int[]{1,3,2}, a);
    }
}
