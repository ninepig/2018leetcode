package Dp;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 *
 */

/**
 *  自低向上的 dp题
 *  借助一个辅助的数组
 *  记录从底部到上，相邻结点最小的值。
 */
public class triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] min = new int[triangle.size()+1];
        for(int i = triangle.size()-1;i>=0;i--){
            for(int j = 0 ; j<= i ; j++){
                min[j] = Math.min(min[j],min[j+1])+triangle.get(i).get(j);
            }
        }
        // We just have one node at top. So the min value is the first of array.
        return min[0];
    }
}
