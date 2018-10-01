package Dp;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */

/**
 * 没想到是个dp题，当要考虑有多少啊，是否相似啊 这种情况，要考虑用dp来解决
 * 4个要素 见笔记。
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // State.
        int[] dp = new int[n+1];

        // State initial.
        dp[0] = 1;
        dp[1] = 1;

        // State transfer.
        for(int i = 2; i <= n ; i++){
            for(int j = 0 ; j < i ; j++ ){
                dp[i] += dp[i-1-j]*dp[j];
            }
        }
        // Result.
        return dp[n];
    }
}
