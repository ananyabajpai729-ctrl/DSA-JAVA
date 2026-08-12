import java.util.ArrayList;
import java.util.List;

class Solution {
   
    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return; 
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public List<Integer> mergeTwoBST(TreeNode p, TreeNode q) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        inorder(p, arr1);
        inorder(q, arr2);

        int i = 0, j = 0;
        
        
        int n = arr1.size(); 
        int m = arr2.size();
        List<Integer> ans = new ArrayList<>();

        
        while (i < n && j < m) {
            if (arr1.get(i) <= arr2.get(j)) {
                ans.add(arr1.get(i++));
            } else {
                ans.add(arr2.get(j++));
            }
        }
        while (i < n) {
            ans.add(arr1.get(i++));
        }
        while (j < m) {
            ans.add(arr2.get(j++));
        }
        return ans;
    }
}

