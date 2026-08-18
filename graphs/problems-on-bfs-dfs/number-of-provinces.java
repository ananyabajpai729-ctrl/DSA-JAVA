class Solution {
    private void dfs(boolean[] vis, int node, List<List<Integer>> adj){
        vis[node] = true;

        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                dfs(vis, neighbour, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[V];
        int ans = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                ans++;
                dfs(vis, i, adj);
            }
        }

        return ans;
    }
}
