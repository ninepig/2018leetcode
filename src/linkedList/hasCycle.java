package linkedList;

/**
 * 快慢指针来做。做烂掉了
 */
public class hasCycle {
    public boolean hasCycleI(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow =head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        // Check if it is a cycle.
        if(fast.next==null||fast.next.next ==null){
            return null;
        }
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
