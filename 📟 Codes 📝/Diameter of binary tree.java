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
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxPath(root);
        return this.result - 1;
    }
    private int maxPath(TreeNode root){
        if(root == null) return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        this.result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}