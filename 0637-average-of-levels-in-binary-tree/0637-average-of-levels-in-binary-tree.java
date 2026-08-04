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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();//to store the ans
        Queue<TreeNode> q = new LinkedList<>();//for bfs traversal
        q.offer(root);//added root
        while(!q.isEmpty()){
            long sum = 0;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                //left child
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                //right child
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            //average of current level
            ans.add((double)sum / size);
        }
        return ans;
    }
}