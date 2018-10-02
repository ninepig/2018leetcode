package backtracking;

import tree.TreeNode;

public class binaryTreeFromPostAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length == 0 || inorder.length!=postorder.length){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1 , postorder , postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int start, int end, int[] postorder, int post_pos) {
        if(start > end || post_pos < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_pos]);
        int index = start;
        while(index <= end ){
            if(inorder[index] == postorder[post_pos]){
                break;
            }
            index++;
        }
        root.left = helper(inorder,start,index-1,postorder,post_pos - (end - index)-1);
        root.right = helper(inorder,index+1,end,postorder,post_pos-1);
        return root;
    }
}
