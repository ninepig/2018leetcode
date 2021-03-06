package linkedList;

/**
 * 21
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class mergeTwoListNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else{
                if(l1.val <= l2.val){
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            head = head.next;
        }
        return dummy.next;

    }
}
