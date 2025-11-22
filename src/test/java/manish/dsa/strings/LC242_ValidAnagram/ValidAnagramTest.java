
package manish.dsa.strings.LC242_ValidAnagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidAnagramTest {
    @Test
    public void testBasic() {
        ValidAnagram v = new ValidAnagram();
        assertTrue(v.isAnagram("anagram","nagaram"));
        assertFalse(v.isAnagram("rat","car"));
    }
    @Test
    public void testEdge() {
        ValidAnagram v = new ValidAnagram();
        assertFalse(v.isAnagram("a", "ab"));
    }
}
