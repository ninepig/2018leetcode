package linkedList;

public class reorderList {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        // Find mid point.
        ListNode mid = findMid(head);

        // Reverse second half.
        ListNode secHalf = reverse(mid.next);

        //Cut first half 's tail.
        mid.next = null;

        // Merge two list.
        Merge(head,secHalf);
    }

    private ListNode findMid(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private void Merge(ListNode head, ListNode secHalf){
        ListNode pre = new ListNode(0);
        int index = 0;
        while(head!=null && secHalf!=null){
            if(index%2==0){
                pre.next = head;
                head = head.next;
            }else{
                pre.next = secHalf;
                secHalf = secHalf.next;
            }
            index++;
            pre = pre.next;
        }
        if(head!=null){
            pre.next = head;
        }
        if(secHalf !=null){
            pre.next = secHalf;
        }

    }
}
