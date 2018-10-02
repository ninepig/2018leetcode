package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrderTraversal {

    public List<List<Integer>>  levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            // Little Bug, you need get level size before adding something!
            int currentLevelSize = queue.size();
            List<Integer> curRes = new ArrayList();

            for(int i = 0 ; i < currentLevelSize;i++){
                TreeNode currentNode = queue.pop();
                curRes.add(currentNode.val);

                if(currentNode.left != null){
                    // You will not want to use push. Push will insert at the head of list.
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }

            res.add(curRes);
        }
        return res;
    }

}
