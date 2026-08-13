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
class BSTIterator{
    private java.util.Stack<TreeNode> stack;
    private boolean reverse;

    BSTIterator(TreeNode root, boolean isReverse){
        stack = new Stack<>();
        this.reverse = isReverse;
        pushAll(root);
    }
    boolean hasNext(){
        return !stack.isEmpty();
    }
    int next(){
        TreeNode temp = stack.pop();
        if(!reverse){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if(reverse){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
