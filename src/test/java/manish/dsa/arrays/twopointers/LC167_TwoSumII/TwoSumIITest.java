
package manish.dsa.arrays.twopointers.LC167_TwoSumII;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TwoSumIITest {
    @Test
    public void testExample() {
        TwoSumII sol = new TwoSumII();
        int[] res = sol.twoSum(new int[]{2,7,11,15}, 9);
        assertArrayEquals(new int[]{0,1}, res);
    }
    @Test
    public void testNo() {
        TwoSumII sol = new TwoSumII();
        int[] res = sol.twoSum(new int[]{1,2,3}, 7);
        assertEquals(0, res.length);
    }
}
