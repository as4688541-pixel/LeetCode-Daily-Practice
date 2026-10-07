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
    private boolean flag;
    public int level(TreeNode root){
        if(root == null)return 0;
        int leftlevel = level(root.left);
        int rightlevel = level(root.right);
        if(Math.abs(leftlevel - rightlevel) > 1)flag = false;
        return 1 + Math.max(leftlevel,rightlevel);

    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        level(root);
        return flag;
        
    }
}