package tree;

/**
 * https://www.youtube.com/watch?v=LfKRZ_qCmYQ
 * because we can not do that with extra space. So we have to do the thing reverse
 * get 6 then 5, 4, 3, 2,1
 * we get 6 first, set right to null , left to null. pre become 6, then we have 5....
 */
public class FlattenBinaryTreeTolinkedList {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
