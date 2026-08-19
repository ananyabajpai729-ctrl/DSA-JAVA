class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        image[sr][sc] = color;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(target == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()){

            int[] pos = q.poll();

            for(int[] d : dirs){
                int nr = pos[0] + d[0];
                int nc = pos[1] + d[1];

                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == target){
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
            
        }

        return image;
    }
}
