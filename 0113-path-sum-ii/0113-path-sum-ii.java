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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        hasPathSum(list,root,targetSum,new ArrayList<>());
        return list;
    }
   public void hasPathSum(List<List<Integer>> list,TreeNode root, int targetSum ,List<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.val);
        if(targetSum == root.val && root.left == null && root.right == null){
            list.add(new ArrayList<>(path));
        }else{
            hasPathSum(list,root.right,targetSum - root.val, path);
            hasPathSum(list,root.left,targetSum - root.val, path); 
        }
        
        path.removeLast();
    }
}