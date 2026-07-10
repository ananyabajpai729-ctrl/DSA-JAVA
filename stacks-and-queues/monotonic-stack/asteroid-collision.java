class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stk = new ArrayList<>();

        for(int i = 0; i< asteroids.length; i++){
            int aster = asteroids[i];

            if(aster > 0){
                stk.add(aster);
            }
            else{
                while(!stk.isEmpty() && stk.get(stk.size() - 1) > 0 && stk.get(stk.size() -1) < Math.abs(aster)){
                    stk.remove(stk.size() - 1);
                }

                if (!stk.isEmpty() && stk.get(stk.size() - 1) == Math.abs(aster)) {
                    stk.remove(stk.size() - 1);
                } 

                else if (stk.isEmpty() || stk.get(stk.size() - 1) < 0) {
                    stk.add(aster);
                }
            }
        }

        int[] result = new int[stk.size()];
        for (int i = 0; i < stk.size(); i++) {
            result[i] = stk.get(i);
        }

        
        return result;
    }
}
