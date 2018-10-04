package tree;

/**
 *  同 balancedTree, 对于递归之中的树或者其他算法，如果是要判读boolean ，可以用一个额外的变量来设置。在递归中发现满足条件的情况，设置这个boolean值
 */
public class pathSum {
    boolean ifExit = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        helper(root,sum);
        return ifExit;
    }
    private void helper(TreeNode root,int sum){
        if(root == null){
            return;
        }
        // PreOrder.
        if(root.left == null && root.right == null && root.val == sum){
            ifExit = true;
        }
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}
