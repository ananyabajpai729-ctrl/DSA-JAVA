class Solution {
    private void dfs(int node, List<List<Integer>> adj, Stack<Integer> st, boolean[] vis){
        vis[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, st, vis);
            }
        }
        st.push(node);
    }
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] ans = new int[V];
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, adj, st, vis);
            }
        }

        int index = 0;
        while (!st.isEmpty()) {
            ans[index++] = st.pop();
        }
        return ans;
    }
}
