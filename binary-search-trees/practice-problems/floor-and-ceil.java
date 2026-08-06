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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        TreeNode curr = root;
        int floor = -1;
        while(curr != null){
            if(curr.data == key){
                floor = curr.data;
                break;
            }else if(curr.data < key){
                floor = curr.data;
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        int ceil = -1;
        curr = root;
        while(curr != null){
            if(curr.data == key){
                ceil = curr.data;
                break;
            }else if(curr.data > key){
                ceil = curr.data;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        ans.add(floor);
        ans.add(ceil);
        return ans;
    }
}
