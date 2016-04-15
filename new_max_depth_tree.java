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
    int maxDepth = 0;
    public void dfs(TreeNode node, int currLevel) {
        if(node.left != null)
            dfs(node.left, currLevel+1);
        if(node.right != null)
            dfs(node.right, currLevel+1);
        if(node.left == null && node.right == null) {
            maxDepth = currLevel > maxDepth ? currLevel : maxDepth;
        }
    }
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        if(root == null) return maxDepth;
        dfs(root, 1);
        return maxDepth;
    }
}
