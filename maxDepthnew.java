/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int num = Integer.MIN_VALUE;
    
    public void dfs(TreeNode node, int level) {
        if(node.left == null && node.right == null) {
            if(level > num) num = level;
            return;
        }
        if(node.left != null)
            dfs(node.left, level+1);
        if(node.right != null)
            dfs(node.right, level+1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 1);
        return num;
    }
}