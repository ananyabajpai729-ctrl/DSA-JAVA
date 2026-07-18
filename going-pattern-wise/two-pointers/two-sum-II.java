class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for(int idx1 = 0, idx2 = numbers.length - 1; idx1 < idx2; ){
            int sum = numbers[idx1] + numbers[idx2];

            if(sum ==  target) return new int[]{idx1 + 1, idx2 + 1};

            if(sum > target) idx2--;
            else idx1++;
        }
        return new int[]{-1, -1};
    }
}
