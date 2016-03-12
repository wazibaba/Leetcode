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
    public boolean hasPathSum(TreeNode root, int sum) {
        //[-2,null,-3]     -2
        //       -2 
        //   null   -3  should return false;
        if(root == null) return false;
        if(root.left == null && root.right == null) 
        {
            if (root.val == sum) 
                return true;
            else
                return false;
        }
        return (root.left != null && hasPathSum(root.left, sum - root.val)) || (root.right!=null && hasPathSum(root.right, sum - root.val));
        
    }
}