class Solution {
    public int countPainters(int[] board, int k){
        int count = 1;
        int sum = 0;
        for(int i = 0; i< board.length; i++){
            if(sum + board[i] <= k){
                sum += board[i];
            }else{
                count++;
                sum = board[i];
            }
        }
        return count;
    }
    public int paint(int A, int B, int[] C) {
        // Your code goes here
        int start = Arrays.stream(C).max().getAsInt();
        int end = Arrays.stream(C).sum();

        while(start <= end){
            int mid = start + (end - start)/2;
            if(countPainters(C, mid) <= A){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (start * B) % 10000003;
    }
}
