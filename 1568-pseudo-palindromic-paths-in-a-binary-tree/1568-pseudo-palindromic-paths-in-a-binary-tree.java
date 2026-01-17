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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode Node , int mask) {
        if(Node == null) return 0;
        mask ^= (1 << Node.val);
        if(Node.left == null && Node.right == null){
            if((mask & (mask - 1)) == 0){
                return 1;
            }else{
                return 0;
            }
        }
        return dfs(Node.left, mask) + dfs(Node.right, mask);
    }
}