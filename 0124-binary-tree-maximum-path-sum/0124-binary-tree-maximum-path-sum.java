/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPath(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0,maxPath(root.left));
        int right = Math.max(0,maxPath(root.right));
        int total = root.val + left + right;
        max = Math.max(total,max);
        return root.val + Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return root.val;

         int x = maxPath(root);
        return max;

    }
}