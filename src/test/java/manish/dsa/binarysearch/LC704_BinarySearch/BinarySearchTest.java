
package manish.dsa.binarysearch.LC704_BinarySearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    @Test
    public void testIterative() {
        BinarySearch b = new BinarySearch();
        assertEquals(3, b.searchIterative(new int[]{-1,0,3,5,9,12}, 5));
        assertEquals(-1, b.searchIterative(new int[]{-1,0,3,5,9,12}, 2));
    }
    @Test
    public void testRecursive() {
        BinarySearch b = new BinarySearch();
        assertEquals(4, b.searchRecursive(new int[]{1,2,3,4,5,6}, 5));
        assertEquals(-1, b.searchRecursive(new int[]{1,2,3}, 9));
    }
}
