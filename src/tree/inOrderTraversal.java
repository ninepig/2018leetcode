package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  树的遍历，如果用递归的方式 以及不用递归的方式（stack）
 */

public class inOrderTraversal {

    // Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        helper(root,res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        if(root == null ){
            return ;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    // Iterative
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                // Push all left node till leaf.
                stack.push(root);
                root = root.left;
            }
            // Pop out one node to be the root.
            root = stack.pop();
            res.add(root.val);
            // Go through right part of tree.
            root = root.right;
        }
        return res;
    }

}
