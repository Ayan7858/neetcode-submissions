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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        preorder(root, root.val);
        return count; 
    }

    int count = 0;
    private void preorder(TreeNode node, int maxValue){
        if(node == null) return;
        if(node.val >= maxValue){
            count++;
            maxValue = node.val;
        }
        preorder(node.left,maxValue);
        preorder(node.right,maxValue);
    }
}
