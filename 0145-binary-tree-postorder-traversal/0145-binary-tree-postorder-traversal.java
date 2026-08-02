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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode current = st.pop();
            // Root add karo
            ans.add(current.val);
            // Left pehle push karo
            if(current.left != null){
                st.push(current.left);
            }
            // Right baad me push karo
            if(current.right != null){
                st.push(current.right);
            }
        }
        // Root Right Left ko reverse karke
        // Left Right Root bana denge
        Collections.reverse(ans);
        return ans;
    }
}