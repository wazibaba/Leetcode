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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;
        return invertTree_helper(root);
        
    }
    public TreeNode invertTree_helper(TreeNode node)
    { 
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        TreeNode left = node.left; TreeNode right = node.right;
        node.left = null; node.right = null;
        if(left != null)
            node.right = invertTree_helper(left);
        if(right != null)
            node.left = invertTree_helper(right);
        return node;
    }
}