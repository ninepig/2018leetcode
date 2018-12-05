package linkedList;

/**
 * 82
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class removeDuplicatedII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                while(cur.next!= null &&(cur.next.val == temp)){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return  dummy.next;
    }
}
