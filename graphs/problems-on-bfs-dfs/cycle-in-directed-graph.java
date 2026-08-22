class Solution {
    private boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, int node){
        vis[node] = true;
        pathVis[node] = true;

        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(adj, vis, pathVis, it)) return true;
            }else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!vis[i]){
                if(dfs(adj, vis, pathVis, i)) return true;
            }
        }

        return false;
    }
}
