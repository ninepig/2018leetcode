package backtracking;

import tree.TreeNode;

/**
 *  backtracking 的方式去做这个题
 *  分析 preorder 以及inorder的顺序
 *  对于root来说 他是preorder的第一位 然后对于inorder来说 preorder这个值的左边是左树，然后是右树
 *  一步一步分析出来递归的条件
 *  这个题应该是o（nlogn） 因为走了全部的inorder 和preorder ，同时在loop之中要search，可以用一个hashmap 来避免查询
 */
public class binaryTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || preorder.length!=inorder.length){
            return null;
        }
        return helper(preorder,inorder,0,0,inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder,int pre_pos , int in_begin, int in_end){
        if(pre_pos >= preorder.length || in_begin > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_pos]);
        int i = in_begin;
        while(i <= in_end){
            if(inorder[i] == preorder[pre_pos]){
                break;
            }
            i++;
        }
        root.left = helper(preorder,inorder,pre_pos+1,in_begin,i-1);
        root.right = helper(preorder,inorder,pre_pos+(i-in_begin)+1,i+1,in_end);

        return root;
    }
}
