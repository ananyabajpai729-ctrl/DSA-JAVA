class Solution {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            index++;
            int node = q.poll();

            for(int it: adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return index != V;
    }
}
