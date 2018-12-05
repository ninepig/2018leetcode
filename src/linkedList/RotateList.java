package linkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        // Count the length of list , just in case k bigger than length.
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            length++;
            fast = fast.next;
        }
        fast = head;
        // Fast pointer move k at first.
        for(int i = 0; i < k % length ; i++){
            fast = fast.next;
        }
        // Fast node reach the tail.
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next =null;

        return head;

    }
}
