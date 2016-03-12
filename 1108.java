/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

				4
			3        3
	44         5   7  
                     8

public class Solution {
    public int minDepth(TreeNode root) {
    	if root.left == null and root.right == null return 1;
        else if root.left != null && root.right == null:
        	return 1  + Math.min(minDepth(root.left))
        else if:
        	return 1 + Math.min(root.right);
        else:
        	return 1 + Math.min(between left and right);
    }
}


[1, 2 ]

   1
  2
expect : 2
output   1. 

    