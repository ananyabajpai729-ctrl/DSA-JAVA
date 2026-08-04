class Solution {
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void dfs(TreeNode root, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;

        path.add(root.data);

        if (isLeaf(root)) {
            ans.add(new ArrayList<>(path));
        } else {
            if (root.left != null) dfs(root.left, path, ans);
            if (root.right != null) dfs(root.right, path, ans);
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }
}
