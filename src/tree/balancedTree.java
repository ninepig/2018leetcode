package tree;

/**
 *  特殊方法需要总结。
 *  因为是高度平衡的树， 所以计算节点 左右高度，然后比较 是否超过1 如果超过1， 则直接表明false
 *  利用了一个全局变量。 在backtracking之中的判断问题，可以一直用这种方法。
 */
public class balancedTree {
    boolean ifBal = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        helper(root);
        return ifBal;
    }
    // Get depth of the tree
    private int helper(TreeNode root){

        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1){
            ifBal = false;
        }
        return Math.max(left,right)+1;
    }
}
