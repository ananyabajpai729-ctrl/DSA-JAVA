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
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    private void leftBoundary(TreeNode root, List<Integer> ans){
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)){
                ans.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    private void bottomBoundary(TreeNode root, List<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left != null){
            bottomBoundary(root.left, ans);
        }
        if(root.right != null){
            bottomBoundary(root.right, ans);
        }
    }
    private void rightBoundary(TreeNode root, List<Integer> ans){
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr!= null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        for(int i = temp.size() - 1; i >=0; i--){
            ans.add(temp.get(i));
        }
    }
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.data);
        leftBoundary(root, ans);
        bottomBoundary(root, ans);
        rightBoundary(root, ans);
        return ans;
    }
}
