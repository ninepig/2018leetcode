package tree;

import java.util.LinkedList;

public class maxDepthOfTree {
    public int maxDepthDfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepthDfs(root.left),maxDepthDfs(root.right))+1;
    }

    public int maxDepthBfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int currentSize = queue.size();
            while(currentSize>0){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                currentSize--;
            }
            level++;
        }

        return level;
    }
}
