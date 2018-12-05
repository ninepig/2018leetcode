package linkedList;

/**
 * 83
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class removeDuplicatesI {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                // If current val equals to next's val, remove the next node.
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }
}
