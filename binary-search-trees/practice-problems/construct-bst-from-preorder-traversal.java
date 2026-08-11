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
    int i = 0;
    private TreeNode builder(int[] preorder, int min, int max){
        if(i >= preorder.length) return null;
        int val = preorder[i];

        if(val < min || val > max) return null;

        i++;
        TreeNode curr = new TreeNode(val);
        curr.left= builder(preorder, min, curr.val);
        curr.right = builder(preorder, curr.val, max);
        return curr;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return builder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
