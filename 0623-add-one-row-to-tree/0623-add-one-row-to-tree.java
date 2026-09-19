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
    void helper(TreeNode root , int val, int count , int depth){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){

            int size = q.size(); 

            for(int i=0; i<size; i++){
            TreeNode front = q.remove();
            if(count + 1 == depth){
                TreeNode left = new TreeNode(val);
                TreeNode right = new TreeNode(val);
                TreeNode leftsub = front.left;
                TreeNode rightsub = front.right;

                front.left = left;
                front.right = right;
                left.left = leftsub;
                right.right = rightsub;
            }
            if(front.left != null)q.add(front.left);
             if(front.right != null)q.add(front.right);
            }

              count++;
     }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root, val , 1 , depth);

        return root;
        
    }
}