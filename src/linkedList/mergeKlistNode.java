package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class mergeKlistNode {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.poll();
            head.next = temp;
            if(temp.next!=null){
                // Bug!
                minHeap.offer(temp.next);
            }
            head = head.next;
        }

        return dummy.next;
    }
}
