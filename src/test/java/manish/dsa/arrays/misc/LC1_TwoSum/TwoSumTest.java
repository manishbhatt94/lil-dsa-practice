
package manish.dsa.arrays.misc.LC1_TwoSum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    @Test
    public void testBasic() {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[]{2,7,11,15}, 9);
        assertArrayEquals(new int[]{0,1}, res);
    }
    @Test
    public void testNoSolution() {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[]{1,2,3}, 7);
        assertEquals(0, res.length);
    }
}
