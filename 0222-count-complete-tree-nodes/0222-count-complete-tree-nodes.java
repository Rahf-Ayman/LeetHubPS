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
    public int  getLeftHeight(TreeNode root){
        int h = 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return h ;
    }

    public int  getReightHeight(TreeNode root){
        int h = 0;
        while(root != null){
            root = root.right;
            h++;
        }
        return h ;
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0; // base case
        }
        int l = getLeftHeight(root);
        int r = getReightHeight(root);

        if(l == r){
            return  (int) Math.pow(2 , l) - 1; //complete BT
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}