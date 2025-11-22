
package manish.dsa.arrays.slidingwindow.LC3_LongestSubstring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringTest {
    @Test
    public void testExamples() {
        LongestSubstring s = new LongestSubstring();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }
    @Test
    public void testEmpty() {
        LongestSubstring s = new LongestSubstring();
        assertEquals(0, s.lengthOfLongestSubstring(""));
    }
}
