package tree;

import java.util.Stack;

/**
 *  O(n) TIME O(n) space
 */

public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack();

        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }


    public boolean isValidBSTRec(TreeNode root) {

        return helper(root , Long.MIN_VALUE, Long.MAX_VALUE);

    }
    public boolean helper(TreeNode root, Long minValue, Long maxValue){
        if(root == null ){
            return true;
        }
        if(root.val<=minValue||root.val>=maxValue){
            return false;
        }
        return helper(root.left,minValue,(long)root.val)&&helper(root.right,(long)root.val,maxValue);


    }
}
