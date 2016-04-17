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
    public int max;
    public int help(TreeNode node) {
        if(node == null) return 0;
        int leftMax = help(node.left);
        int rightMax = help(node.right);
        int arch = leftMax + node.val + rightMax;
        int retMax = Math.max(node.val, Math.max(leftMax, rightMax) + node.val);
        max = Math.max(max, Math.max(arch, retMax));
        return retMax;
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root == null) return 0;
        help(root);
        return max;
    }
}
