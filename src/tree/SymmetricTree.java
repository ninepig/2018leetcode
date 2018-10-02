package tree;

import java.util.LinkedList;

public class SymmetricTree {

    // dfs
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return helper(p.left,q.right)&&helper(p.right,q.left);
    }

    public boolean isSymmetricBFS(TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if(first == null && second == null){
                continue;
            }else if(first == null || second == null){
                return false;
            }else if(first.val != second.val){
                return false;
            }
            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);

        }
        return true;
    }
}
