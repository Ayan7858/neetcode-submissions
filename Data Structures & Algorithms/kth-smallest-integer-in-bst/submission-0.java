class Solution {
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    int count = 0;
    int result = 0;

    private void inorder(TreeNode root, int k){
        if(root == null || count >= k) return;
        inorder(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}