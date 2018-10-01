package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOderTraversal {

    // Recursive
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root ,res );
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null) {
            return ;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);

    }
    // Stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return res;
    }
}
