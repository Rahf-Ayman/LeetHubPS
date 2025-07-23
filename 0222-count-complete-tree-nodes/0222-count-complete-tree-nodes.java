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
    public int countNodes(TreeNode root) {
        int c = 1;
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root == null){
            return 0;
        }
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode curr = qu.poll();
            if(curr.left != null){
                qu.add(curr.left);
                c++;
            }
            if(curr.right != null){
                qu.add(curr.right); 
                c++;
            }
            
            
        }
        return c;
    }
}