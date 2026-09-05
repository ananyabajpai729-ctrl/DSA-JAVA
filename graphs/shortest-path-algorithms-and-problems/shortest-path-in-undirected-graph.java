import java.util.*;
class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {
        int[] ans = new int[N];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: adj.get(node)){
                if(ans[node] + 1 < ans[it]){
                    ans[it] = ans[node] + 1;
                    q.add(it);
                }
    
            }
        }
        for(int i = 0; i < N; i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        return ans;
    }
}
