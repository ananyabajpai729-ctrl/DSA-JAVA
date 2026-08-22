class Solution {
    private boolean dfs(int[] color , int[][] graph, int node, int col){
        color[node] = col;

        for(int it: graph[node]){
            if(color[it] == -1){
                if(dfs(color, graph, it, 1- col) == false) return false;
            }else if(color[it] == col){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(dfs(color, graph, i, 0)== false) return false;
            }
        }
        return true;
    }
}
