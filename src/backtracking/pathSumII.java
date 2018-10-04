package backtracking;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Vickyer @renegade The time complexity of this solution is O(n). It is the same time complexity as that of recursive in-order traversal. An intuitive way to arrive at this answer is asking: how many times does each node in the tree get operated/visited on? The answer is 1 time per node.
 *
 * If you really want to be thorough in explaining to interviewer, one could say: it would be O(n) + O(p h) where p is the number of root to leaf paths and h is the height of the tree. The reason we include O(p*h) is because of the
 *
 * result.add(new LinkedList(currentResult));
 *
 * For each possible path, we have to make a deep copy of this list, which takes O(h) for one path and there are p such paths. But O(n) + O(ph) would be O(n).
 *
 * 因为要构造所有的路径，所以肯定考虑的是backtracking的方法来做，然后找条件来trim tree.
 * 同样注意这个题如果是加入某个cur这种情况，当递归完了以后 要把这个点remove掉，同排列组合一样。
 */

public class pathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(res,cur,root,sum);
        return res;
    }

    private void helper( List<List<Integer>> res, List<Integer> cur,TreeNode root,int sum){
        if(root == null){
            return ;
        }
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }else {
            helper(res, cur , root.left, sum-root.val);
            helper(res, cur , root.right , sum - root.val);
        }
        cur.remove(cur.size()-1);
    }

}
