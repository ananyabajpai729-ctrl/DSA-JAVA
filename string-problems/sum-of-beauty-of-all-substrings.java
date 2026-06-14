class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i< s.length(); i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j< s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int mini = Integer.MAX_VALUE;
                int maxi = Integer.MIN_VALUE;

                for(int val : map.values()){
                    mini = Math.min(val, mini);
                    maxi = Math.max(val, maxi);
                }

                sum += (maxi - mini);
            }
        }

        return sum;
    }
}
