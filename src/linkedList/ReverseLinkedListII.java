package linkedList;

import java.util.Stack;

public class ReverseLinkedListII {

    // Iteritive
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = dummy;

        // Move m - 1 step to the preNode before nodeM.
        for(int i = 1 ; i < m ; i++){
            newHead = newHead.next;
        }

        ListNode preNode = newHead;
        ListNode mNode = preNode.next;
        ListNode nNode = preNode.next.next;

        // Reverse from nodeM to nodeN.
        for(int i = 0 ; i < n - m ; i++){
            mNode.next = nNode.next;
            nNode.next = preNode.next;
            preNode.next = nNode;
            nNode = mNode.next;
        }

        return dummy.next;
    }

    // Stack
    public ListNode reverseBetweenStack(ListNode head, int m, int n) {
        if(head == null ){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preHead = dummy;

        // Move m-1 step to get the node before mNode.
        for(int i = 1 ; i < m-1 ;i++){
            preHead = preHead.next;
        }
        Stack<ListNode> stack = new Stack();
        // A node to record preHead.
        ListNode preNode = preHead;
        // nodeM
        ListNode mNode = preHead.next;

        // Insert into stack.
        int i = 0;
        while(m + i < n){
            stack.push(mNode);
            mNode = mNode.next;
            i++;
        }

        ListNode postNode = mNode;
        ListNode resultNode = stack.pop();
        ListNode tempNode = resultNode;

        while(!stack.isEmpty()){
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }

        preNode.next = resultNode;
        tempNode.next = postNode;

        return dummy.next;
    }
}
