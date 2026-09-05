class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }
        
        int V = adj.size();
        int[] indegree = new int[V];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                int v = graph[i][j];
                adj.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
