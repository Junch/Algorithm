package ltoj;

import java.util.*;

//http://www.cnblogs.com/hiddenfox/p/3408931.html

/**
 * Created by jun on 14-3-4.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return false;
            fast = fast.next;
            if (slow == fast)
                return true;
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {

        ListNode meetNode = getMeetNode(head);
        if (meetNode == null)
            return null;

        return getCycleStart(head, meetNode);
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return null;
            fast = fast.next;
            if (slow == fast)
                break;
        }

        return (fast == null)? null: fast;
    }

    private ListNode getCycleStart(ListNode head, ListNode meetNode) {
        ListNode p = head;
        ListNode q = meetNode;

        while(p != q){
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
