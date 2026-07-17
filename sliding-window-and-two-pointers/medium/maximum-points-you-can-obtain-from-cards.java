class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int sum = 0;

        for(int i = 0; i< k; i++){
            sum += cardPoints[i];
        }

        int maxPoints = sum;

        for(int i = 0; i < k; i++){
            sum -= cardPoints[k - i - 1];

            sum += cardPoints[n - i - 1];

            maxPoints = Math.max(maxPoints, sum);
        }

        return maxPoints;
    }
}
