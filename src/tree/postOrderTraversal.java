package tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postOrderTraversal {

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root,List<Integer> res){
        if(root == null){
            return ;
        }
        helper(root.left, res);
        helper(root.right,res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            // push the left first, because we add right to head at first, then left.
            // So it still will be left, right ,root order.
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        return res;
    }


}
