package ltoj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-3-5.
 */
public class MinimumWindowSubstringTest {
    @Test
    public void testMinWindow() throws Exception {
        MinimumWindowSubstring sln = new MinimumWindowSubstring();
        assertEquals("bea", sln.minWindow("accbea", "ab"));
    }

    @Test
    public void testMinWindowWithoutFounding() throws Exception {
        MinimumWindowSubstring sln = new MinimumWindowSubstring();
        assertEquals("", sln.minWindow("accbea", "ad"));
    }
}
