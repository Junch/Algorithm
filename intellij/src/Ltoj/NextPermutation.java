package Ltoj;

import java.util.*;

/**
 * Created by jun on 14-2-27.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int i = num.length - 1;
        for (; i>0; --i) {
            if (num[i] > num[i-1]) {
                break;
            }
        }

        if (i != 0) {
            int j = i + 1;
            for (; j < num.length; ++j) {
                if (num[j] < num[i-1]) {
                    break;
                }
            }
            --j;

            int temp = num[i-1];
            num[i-1] = num[j];
            num[j] = temp;
        }

        Arrays.sort(num, i, num.length);
    }
}
