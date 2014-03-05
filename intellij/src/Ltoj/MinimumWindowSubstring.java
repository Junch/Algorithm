package ltoj;

/**
 * Created by jun on 14-3-5.
 */
public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        int arr[]= new int[T.length()];
        for (int i: arr)
            i = -1;

        int span = S.length() + 1;
        int start = 0;
        int end = 0;

        for (int i=0; i<S.length(); ++i) {
            int j = T.indexOf(S.charAt(i));
            if (j >= 0) {
                arr[j] = i;

                int min = S.length();
                int max = -2;
                for (int k: arr){
                    if (k < min)
                        min = k;

                    if (k > max)
                        max = k;
                }

                if (min > 0) {
                    int currentSpan = max - min;
                    if (currentSpan < span)
                    {
                        span = currentSpan;
                        start = min;
                        end = max;
                    }
                }
            }
        }

        if (span == S.length() + 1)
            return "";

        return S.substring(start, end+1);
    }
}
