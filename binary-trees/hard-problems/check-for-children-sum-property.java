// class TreeNode {
//     int val;
//     TreeNode left, right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if (curr.left == null && curr.right == null) {
                    continue; 
                }

                int childSum = 0;
                if (curr.left != null) {
                    childSum += curr.left.val;
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    childSum += curr.right.val;
                    q.offer(curr.right);
                }
                
                if (childSum != curr.val) return false;
            }
        }
        return true;
    }
}
