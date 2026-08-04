/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
class Pair{
    TreeNode node;
    int line;

    Pair(TreeNode n , int l){
        node = n;
        line = l;
    }
}
class Solution {
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair entry = q.poll();
            map.put(entry.line, entry.node.data);

            if(entry.node.left != null){
                q.offer(new Pair(entry.node.left, entry.line - 1));
            }
            if(entry.node.right != null){
                q.offer(new Pair(entry.node.right, entry.line + 1));
            }
        }

        for(int val: map.values()){
            ans.add(val);
        }
        return ans;
    }
}
