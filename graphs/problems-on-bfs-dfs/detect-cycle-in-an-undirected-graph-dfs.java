class Solution {
    private boolean dfs(List<Integer>[] adj, boolean[] vis, int node, int parent){
        vis[node] = true;
        for(int neighbour: adj[node]){
            if(!vis[neighbour]){
                if(dfs(adj, vis, neighbour, node) == true){
                    return true;
                }
            }else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            
            if(!vis[i]){
                if(dfs(adj, vis, i, -1) == true){
                    return true;
                }
            }
            
        }
        
        return false;
    }
}
