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
    public int kthSmallest(TreeNode root, int k) {
        //do a in order travelsal, keep tracking for the node to be print, and increase
        if(k == 0) return root.val;
        if(root == null) return -1;
        if(k < 0) return -1;
        //[3,1,4,null,2]  expect to be 3;
            
            //   3
            // 1   4
            //   2
    
        //  2
        //1
        TreeNode curr = root;
        Stack s = new Stack(); 
        while(! s.empty() || curr != null)
        {  
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = (TreeNode)s.peek();
            if(--k == 0)   //time to test the leaf's order 
                break;
            s.pop();
            curr = curr.right;
        }
        return curr.val;
    }
}