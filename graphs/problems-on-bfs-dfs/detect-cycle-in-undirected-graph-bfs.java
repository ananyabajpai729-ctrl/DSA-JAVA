class Solution {
    private class Pair{
        int first;
        int second;
        private Pair(int fst, int sec){
            first = fst;
            second = sec;
        }
    }
    private boolean bfs(List<Integer>[] adj, boolean[] vis, int node){
        vis[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while(!q.isEmpty()){
            int ele = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for(int it : adj[ele]){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(new Pair(it, ele));
                }
                else if(par != it) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            
            if(!vis[i]){
                if(bfs(adj, vis, i) == true){
                    return true;
                }
            }
            
        }
        
        return false;
    }
}
