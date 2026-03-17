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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFSO(root,res,0);
        return res;
    }
    public void DFSO (TreeNode root, List<List<Integer>> res ,int l){
        if(root == null) return;
        
        if(res.size() < l + 1) res.add(new ArrayList<>());
        res.get(l).add(root.val);
        
        DFSO(root.left,res,l + 1);
        DFSO(root.right,res,l + 1); 
    }
}
