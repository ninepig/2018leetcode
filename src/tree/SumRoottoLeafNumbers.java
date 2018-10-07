package tree;

/**
 * 这道题利用path，每往下走一步 *10 + 当前节点， 就形成到当前结点path的value，
 * 然后把所有path加起来就是结果
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return  0;
        }
        return helper(root , 0);
    }

    private int helper(TreeNode root, int sum) {
        if(root == null ){
            return 0;
        }
        int currentSum = sum*10 +root.val;
        if(root.left == null && root.right==null){
            return currentSum;
        }

        int left = helper(root.left,currentSum);
        int right = helper(root.right,currentSum);

        return left + right;
    }
}
