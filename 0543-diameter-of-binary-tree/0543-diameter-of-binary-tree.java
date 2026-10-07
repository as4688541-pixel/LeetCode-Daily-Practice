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
    private int dia;
    public int level(TreeNode root){
        if(root == null)return 0;
        int leftlevels = level(root.left);
        int rightlevels = level(root.right);
        int path = leftlevels + rightlevels;
        dia = Math.max(dia,path);
        return 1 + Math.max(leftlevels, rightlevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        level(root);
        return dia;
        
    }
}