package tree;

public class populatingNextRightPointerInEachNodeII {

    public void connect(TreeLinkedNode root) {
        if(root == null){
            return;
        }
        TreeLinkedNode dummyNode = new TreeLinkedNode();
        TreeLinkedNode pre = dummyNode; // Record the head of next level.
        while(root!=null){
            if(root.left != null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next; // Move to the next node in current level.
            if(root == null) {// End of this level, update to next level.
                root = dummyNode.next;
                pre = dummyNode;
                dummyNode.next = null;
            }
        }
    }
}
