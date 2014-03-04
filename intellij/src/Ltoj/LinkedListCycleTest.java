package ltoj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jun on 14-3-4.
 */
public class LinkedListCycleTest {
    @Test
    public void hasCycle() throws Exception {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        node0.next = node1;
        node1.next = node0;
        LinkedListCycle c = new LinkedListCycle();
        assertEquals(true, c.hasCycle(node0));
    }

    @Test
    public void noCycle() throws Exception {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        node0.next = node1;
        LinkedListCycle c = new LinkedListCycle();
        assertEquals(false, c.hasCycle(node0));
    }
}