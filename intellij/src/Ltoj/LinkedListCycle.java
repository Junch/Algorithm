package ltoj;

import java.util.*;

/**
 * Created by jun on 14-3-4.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode g = head;
        ListNode h = head;

        while (h != null) {
            g = g.next;
            h = h.next;
            if (h == null)
                return false;
            h = h.next;
            if (g == h)
                return true;
        }

        return false;
    }
}
