/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 [4,1,null,2,null,3]
            4 
        1       null
     2   null 
 
 */
public class Solution {
    public int helper(TreeNode root, boolean selected) {
        if(selected) {
            if(root.left == null && root.right == null)
                return root.val;
            int fromLeft = 0; int fromRight = 0;
            if(root.left != null)
                fromLeft = helper(root.left, false);
            if(root.right != null)
                fromRight = helper(root.right, false);
            return fromLeft + fromRight + root.val;
        } else {
            int fromLeft = 0; int fromRight = 0;
            if(root.left == null && root.right == null)
                return 0;
            if(root.left != null)
                fromLeft = helper(root.left, true);
            if(root.right != null)
                fromRight = helper(root.right, true);
             return fromLeft + fromRight; 
        }
    }
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        int a1 = helper(root, true);
        int a2 = helper(root, false);
        return a1 > a2 ? a1 : a2;
    }
}
