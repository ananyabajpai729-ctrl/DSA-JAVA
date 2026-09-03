class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index] = node;
            index++;

            for(int it: adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0) q.add(it);
            }
        }

        if(index == numCourses) return ans;
        else return new int[0];
    }
}
