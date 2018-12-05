package linkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * dummy 节点一定要带一个真正在移动的指针
 */
public class partitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftHead = leftDummy;
        ListNode rightHead = rightDummy;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val < x){
                leftHead.next = cur;
                leftHead = leftHead.next;
            }else{
                rightHead.next =cur;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        leftHead.next = rightDummy.next;
        rightHead.next = null;

        return leftDummy.next;
    }

}
