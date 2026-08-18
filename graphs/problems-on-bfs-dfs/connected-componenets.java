import java.util.*;

class Solution { 
    private void dfs(List<List<Integer>> adj, int node, boolean[] vis){ 
        vis[node] = true; 
        for(int neighbour : adj.get(node)){ 
            if(!vis[neighbour]) dfs(adj, neighbour, vis); 
        } 
    } 

    public int findNumberOfComponent(int V, List<List<Integer>> edges) { 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < V; i++){ 
            adj.add(new ArrayList<>()); 
        } 
        
        // FIX: Iterate through the actual list of edge pairs
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[V]; 
        int count = 0; 
        for(int i = 0; i < V; i++){ 
            if(!vis[i]){ 
                count++; 
                dfs(adj, i, vis); 
            } 
        } 
        return count; 
    } 
}
