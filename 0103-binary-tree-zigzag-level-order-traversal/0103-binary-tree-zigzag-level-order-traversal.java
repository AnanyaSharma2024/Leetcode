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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> revStack = new Stack<>();// for reversing the level when needed
            for(int i = 0 ; i < size ;i++){
                TreeNode node = q.poll();
                //check flaf
                // check flag to decide whether to add normally or in reverse
                if(flag) revStack.add(node.val);//add to sstack
                else level.add(node.val);//add to normal

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            flag = !flag;// change direction for the next level
            while(!revStack.isEmpty()){
                level.add(revStack.pop());// add the current level to the final result
            }
            res.add(level);
        }
        return res;
    }
}