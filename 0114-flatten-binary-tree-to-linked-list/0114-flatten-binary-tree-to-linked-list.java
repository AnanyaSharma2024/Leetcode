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
    public void flatten(TreeNode root) {
        if(root == null){
            return ;//if tree empty return empty
        }
        Stack<TreeNode> st = new Stack<>();//for acting like a recursion 
        st.push(root);//pushing root into the stack
        while(!st.isEmpty()){
            TreeNode current = st.pop();
            //push right first kyuki stack LIFO pr kaam krta hai 
            if(current.right != null){
                st.push(current.right);
            }
            //then push left 
            if(current.left != null){
                st.push(current.left);
            }
            if(!st.isEmpty()){//isse ArraylIST ki tarah use kr rhe h isme sab right side of the tree store hota ja rha h
                current.right = st.peek();
            }
            current.left = null;
        }
    }
}