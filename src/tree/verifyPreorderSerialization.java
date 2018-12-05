package tree;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 特别牛逼的方法， 用入度和出度来维护
 * 初始化的时候对于第一个root 有一个入度，
 * 然后如果有一个节点存在 入度+2（不是#的节点）， 每传递到下一个节点 ，消耗点一个diff，当diff小于0的时候 ，表示树不能被构成
 * 最终degree == 0 是判断条件
 * time o（n）
 */
public class verifyPreorderSerialization {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int degree = 1;
        for(String node : nodes){
            if(--degree < 0) return false;
            if(!node.equals("#")) degree += 2;
        }
        return degree == 0;
    }
}
