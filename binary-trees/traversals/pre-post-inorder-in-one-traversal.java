/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null }
 * }
 **/

class Solution {
    
    public List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();    
        List<List<Integer>> result = new ArrayList<>();


        if (root == null) return result;

        
        Stack<Map.Entry<TreeNode, Integer>> st = new Stack<>();    

        st.push(new AbstractMap.SimpleEntry<>(root, 1));

        while (!st.isEmpty()) {
            Map.Entry<TreeNode, Integer> it = st.pop();
            TreeNode node = it.getKey();
            int state = it.getValue();

            if (state == 1) {
                pre.add(node.data);
                it.setValue(2); 
                st.push(it);   

                if (node.left != null) {
                    st.push(new AbstractMap.SimpleEntry<>(node.left, 1));
                }
            } else if (state == 2) {
                in.add(node.data);
                it.setValue(3); 
                st.push(it);  

                if (node.right != null) {
                    st.push(new AbstractMap.SimpleEntry<>(node.right, 1));
                }
            } else {
                post.add(node.data);
                
            }
        }

    
        result.add(in);
        result.add(pre);
        result.add(post);

        return result;
    }
}
