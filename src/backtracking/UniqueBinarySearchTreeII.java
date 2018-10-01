package backtracking;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题挺难的。但是一眼看上去就知道是要用backtracking，尝试各种possibility， 然后利用条件剪枝
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return  helper(1,n);
    }
    private List<TreeNode>  helper(int min , int max){
        List<TreeNode> res = new ArrayList<>();
        if(min > max){
            return res;
        }
        for(int rt = min ; rt <= max ; rt++){
            List<TreeNode> lefts = helper(min, rt-1);
            List<TreeNode> rights = helper(rt+1,max);
            if(lefts.size() == 0 && rights.size() == 0){
                TreeNode root = new TreeNode(rt);
                res.add(root);
            }else if (lefts.size() == 0){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(rt);
                    root.right = right;
                    res.add(root);
                }
            }else if (rights.size() == 0){
                for(TreeNode left : lefts){
                    TreeNode root = new TreeNode(rt);
                    root.left = left;
                    res.add(root);
                }
            }else{
                for(TreeNode left: lefts){
                    for(TreeNode right : rights){
                        TreeNode root = new TreeNode(rt);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
