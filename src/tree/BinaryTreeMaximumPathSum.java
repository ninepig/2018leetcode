package tree;

/**
 *  类似 path sum ， balanced tree ,利用全局变量来维护最大值，
 *  递归的关键是在于 找到规律
 *  最大值可能是当前点+左路径+右路径 的最大值
 *  递归辅助函数返回的是到目前节点路径的最大值
 */

public class BinaryTreeMaximumPathSum {

    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return maxValue;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        // Left path and right path.
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        maxValue = Math.max(maxValue, left+right+root.val);

        return Math.max(left,right)+root.val;
    }

}
