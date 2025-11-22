
package manish.dsa.linkedlist.LC876_MiddleOfLinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiddleOfLinkedListTest {
    @Test
    public void testOdd() {
        MiddleOfLinkedList.ListNode n1 = new MiddleOfLinkedList.ListNode(1);
        MiddleOfLinkedList.ListNode n2 = new MiddleOfLinkedList.ListNode(2);
        MiddleOfLinkedList.ListNode n3 = new MiddleOfLinkedList.ListNode(3);
        MiddleOfLinkedList.ListNode n4 = new MiddleOfLinkedList.ListNode(4);
        MiddleOfLinkedList.ListNode n5 = new MiddleOfLinkedList.ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        MiddleOfLinkedList sol = new MiddleOfLinkedList();
        MiddleOfLinkedList.ListNode mid = sol.middleNode(n1);
        assertEquals(3, mid.val);
    }
    @Test
    public void testEven() {
        MiddleOfLinkedList.ListNode n1 = new MiddleOfLinkedList.ListNode(1);
        MiddleOfLinkedList.ListNode n2 = new MiddleOfLinkedList.ListNode(2);
        MiddleOfLinkedList.ListNode n3 = new MiddleOfLinkedList.ListNode(3);
        MiddleOfLinkedList.ListNode n4 = new MiddleOfLinkedList.ListNode(4);
        n1.next = n2; n2.next = n3; n3.next = n4;
        MiddleOfLinkedList sol = new MiddleOfLinkedList();
        MiddleOfLinkedList.ListNode mid = sol.middleNode(n1);
        // for even, returns second middle (LeetCode's definition)
        assertEquals(3, mid.val);
    }
}
