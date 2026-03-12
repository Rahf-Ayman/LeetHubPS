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
    public boolean isBalanced(TreeNode root) {
        boolean isBalanced = true;
        return dfsTree(root ,isBalanced) != -1;
    }

    public int dfsTree(TreeNode root ,boolean isBalanced){
        if(root == null) return 0;

        int left = dfsTree(root.left ,isBalanced);
        if (left == -1) return -1;
        int right = dfsTree(root.right,isBalanced);
        if (right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return 1 + Math.max(left ,right);
    }
}