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
    public static class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode n, int i){
            node = n;
            idx = i;
        }
    }
    public static int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int minIndex =  q.peek().idx;

            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i ++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                int currIndex = p.idx - minIndex;
                if(i == 0 ) first = currIndex;;
                if(i == size - 1 ) last = currIndex;
               
                if(curr.left != null) q.offer(new Pair(curr.left, 2 * currIndex + 1));
                if(curr.right != null) q.offer(new Pair(curr.right, 2* currIndex + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
