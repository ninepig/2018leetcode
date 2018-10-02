package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelZigZagOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            // Little Bug, you need get level size before adding something!
            int currentLevelSize = queue.size();
            List<Integer> curRes = new ArrayList();

            for(int i = 0 ; i < currentLevelSize;i++){
                TreeNode currentNode = queue.pop();
                if(level % 2 == 1){
                    curRes.add(currentNode.val);
                }else{
                    curRes.add(0,currentNode.val);
                }
                if(currentNode.left != null){
                    // You will not want to use push. Push will insert at the head of list.
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            level++;
            res.add(curRes);
        }
        return res;
    }

}
