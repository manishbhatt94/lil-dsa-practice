
package manish.dsa.arrays.slidingwindow.LC3_LongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last.containsKey(c)) {
                start = Math.max(start, last.get(c) + 1);
            }
            last.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
