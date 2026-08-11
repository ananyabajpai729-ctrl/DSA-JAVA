/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    List<Integer> succPredBST(TreeNode root, int key) {
        TreeNode curr = root;
        int successor = -1;
        int pred = -1;

        while(root != null){
            if(root.data <= key){
                root = root.right;
            }else{
                successor = root.data;
                root = root.left;
            }
        }
        root = curr;
        while(root != null){
            if(root.data < key){
                pred = root.data;
                root = root.right;
            }else{
                root = root.left;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(pred);
        ans.add(successor);
        return ans;
    }
}
