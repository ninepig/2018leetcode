package tree;

import linkedList.ListNode;


public class sortedLinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return helper(head,null);
    }
    private TreeNode helper(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,tail);

        return root;
    }
}
