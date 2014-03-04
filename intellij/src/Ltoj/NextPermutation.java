package ltoj;

import java.util.*;

/**
 * Created by jun on 14-2-27.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int i = indexToDecrease(num);
        if (i != 0) {
            swapWithSmallestBiggerValue(num, i);
        }

        Arrays.sort(num, i, num.length);
    }

    private void swapWithSmallestBiggerValue(int[] num, int i) {
        int j = i + 1;
        while(j < num.length && num[j] > num[i-1])
            ++j;
        --j;

        int temp = num[i-1];
        num[i-1] = num[j];
        num[j] = temp;
    }

    private int indexToDecrease(int[] num) {
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i])
            --i;

        return i;
    }
}
