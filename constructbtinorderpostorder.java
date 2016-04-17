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
    /*
                6
            1       8
          2   3   9  10
    inorder: 2, 1, 3, 6, 9, 8, 10
    postorder: 2, 3, 1, 9, 10, 8, 6(root)
    
    */
    public int findIndex(int[] array, int s, int e, int target) {
        for(int i = s; i <= e; i++) {
            if(array[i] == target)
                return i;
        }
        return -1;
    }
    public TreeNode bt(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        //[1,2,3,4,5]
        //[1,4,5,3,2]
        if(s1 > e1 || s2 > e2 || s1 < 0 || s2 < 0 || e1 < 0 || e2 < 0) return null;
        if(e1 == s1) { // end s2 == e2 too. 
            TreeNode root = new TreeNode(postorder[e1]);
            root.left = null; root.right = null;
            return root;
        }
        TreeNode root = new TreeNode(postorder[e2]);
        int r1 = findIndex(inorder, s1, e1, postorder[e2]);
        if(r1 == -1) return null;
        int n1 = r1 - s1; //n1 = 1; the position diff is 1.
        int n2 = e1 - r1;
        
            root.left = bt(inorder, postorder, s1, r1-1, s2, s2+n1-1);
            
            root.right = bt(inorder, postorder, r1 + 1, e1, e2 - n2, e2-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        int len2 = postorder.length;
        if(len != len2) return null;
        if(len == 0) return null;
        TreeNode root = bt(inorder, postorder, 0, len-1, 0, len-1);
        return root;
    }
}
