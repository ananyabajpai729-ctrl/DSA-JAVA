class Solution {
    public String findOrder(String [] dict, int N, int K) {
        int[] topo = new int[K];
        int[] indegree = new int[K];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++){
            String wrd1 = dict[i];
            String wrd2 = dict[i+1];

            for(int j = 0; j < Math.min(wrd1.length(), wrd2.length()); j++){
                if(wrd1.charAt(j) != wrd2.charAt(j)){
                    adj.get(wrd1.charAt(j) - 'a').add(wrd2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        for(int i = 0; i < K; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[index++] = node;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        if(index != K) return "";

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < topo.length; i++){
            ans.append((char)(topo[i] + 'a'));
        }
        return ans.toString();
    }
}
