package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelTreeOrderii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            List<Integer> curList = new ArrayList<>();
            for(int i = 0 ; i< currentSize ; i++){
                TreeNode cur = queue.poll();
                curList.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null) {
                    queue.add(cur.right);
                }
            }
            res.add(0,curList);
        }
        return res;
    }
}
