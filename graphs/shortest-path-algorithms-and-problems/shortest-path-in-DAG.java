class Solution {
  private void topoSort(List<Integer> topo, List<List<int[]>> adj, int N, int M){
    Queue<Integer> q = new LinkedList<>();
    int[] indegree = new int[N];
    for(int i = 0; i < N; i++){
        for(int[] it: adj.get(i)){
            indegree[it[0]]++;
        }
    }
    for(int i = 0; i < N; i++){
        if(indegree[i] == 0){
            q.offer(i);
        }
    }
    while(!q.isEmpty()){
        int node = q.poll();
        topo.add(node);
        for(int[] it: adj.get(node)){
            indegree[it[0]]--;
            if(indegree[it[0]] == 0){
                q.offer(it[0]);
            }
        }
    }

  }
  public int[] shortestPath(int N, int M, int[][] edges) {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    //creating adjacency list
    List<List<int[]>> adj = new ArrayList<>();
    for(int i = 0; i < N; i++){
        adj.add(new ArrayList<>());
    }
    for(int i = 0; i < M; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int wt = edges[i][2];
        adj.get(u).add(new int[]{v, wt});
    }

    List<Integer> topo = new ArrayList<>();
    topoSort(topo, adj, N, M);

    for (int node : topo){
        if(dist[node] != Integer.MAX_VALUE){
            for(int[] it: adj.get(node)){
                int neighbour = it[0];
                int wt = it[1];

                if(dist[node] + wt < dist[neighbour]){
                    dist[neighbour] = dist[node] + wt;
                }
            }
        }
    }
    for(int i = 0; i < N; i++){
        if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
    }

    return dist;
  }
}
