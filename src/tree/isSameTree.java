package tree;

import java.util.LinkedList;

public class isSameTree {


    // DFS O(N)
    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }

    // BFS with queue
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first == null || second == null) {
                if(first != second) return false;
            } else if(first.val != second.val) {
                return false;
            } else {
                queue.add(first.left);
                queue.add(second.left);
                queue.add(first.right);
                queue.add(second.right);
            }
        }
        return true;
    }


}
