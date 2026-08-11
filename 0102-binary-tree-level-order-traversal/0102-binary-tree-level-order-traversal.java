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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();//for bsf travel 
        q.add(root); 
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();//for traversing through every node of a level 
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();//take the node out
                level.add(curr.val);//add the node in level
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}