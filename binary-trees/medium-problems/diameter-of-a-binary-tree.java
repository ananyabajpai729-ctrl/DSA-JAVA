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
    private int height(TreeNode root, int[] diameter){
        if(root == null) return 0;

        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(root.left, diameter);
        rh[0] = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0] , lh[0] + rh[0]);

        return Math.max(lh[0], rh[0]) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];

        diameter[0] = 0;

        height(root, diameter);

        return diameter[0];
    }
}
