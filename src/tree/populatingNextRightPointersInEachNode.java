package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * It is like a tree level order travel.
 * o(n)
 */
public class populatingNextRightPointersInEachNode {
    public void connect(TreeLinkedNode root) {
        TreeLinkedNode first = root;
        while(first!=null){
            // Level Order travel
            TreeLinkedNode cur = first;
            while(cur!=null){
                if(cur.left!=null) cur.left.next = cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            first = first.left;
        }
    }

    // BFS is a general way. But it requires extra space.
    public void connectBfs(TreeLinkedNode root) {
        if(root == null)return;
        Queue<TreeLinkedNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                TreeLinkedNode cur = nodes.poll();
                TreeLinkedNode n = null;
                if(i < size - 1){
                    n = nodes.peek();
                }
                cur.next = n;
                if(cur.left != null)nodes.offer(cur.left);
                if(cur.right != null)nodes.offer(cur.right);
            }

        }
    }

}
