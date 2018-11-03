package linkedList;

/**
 * 插入排序，
 * pre 用来维护新的pointer
 * cur 用来维护当前的ListNode
 */
public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode cur = head ;
        // pointer in new list.
        ListNode pre = newHead;
        while(cur!=null){
            ListNode temp = cur.next;
            while(pre.next!=null && pre.next.val < cur.val){
                pre = pre.next;
            }
            // Place to insert cur list.
            cur.next = pre.next;
            pre.next = cur;

            // Restore pointer.
            pre = newHead;
            cur = temp;
        }
        return newHead.next;
    }
}
