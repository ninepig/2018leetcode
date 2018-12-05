package linkedList;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
       if(head == null) return head;
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode curr = dummy;
       while(curr.next != null && curr.next.next != null){
           ListNode first = curr.next;
           ListNode sec = curr.next.next;
           first.next = sec.next;
           sec.next = first;
           curr.next = sec;
           curr = curr.next.next;
       }
       return dummy.next;
    }
}
