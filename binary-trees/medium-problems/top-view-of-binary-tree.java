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
    Pair(TreeNode n, int l){
        node = n;
        line = l;
    }
}
class Solution {
    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair ent = q.poll();
            TreeNode node = ent.node;
            Integer line = ent.line;
            if(!map.containsKey(line)){
                map.put(line, node.data);
            }

            if(node.left != null){
                q.add(new Pair(node.left, line-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, line + 1));
            }
        }
        for(int val : map.values()){
            ans.add(val);
        }
        return ans;
    }   
}
