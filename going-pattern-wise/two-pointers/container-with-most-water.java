class Solution {
    public int maxArea(int[] height) {
        int maxw= -1;
        int j= height.length-1;
        for(int i=0; i<j; ){
            int l= j-i;
            int b= Math.min(height[i], height[j]);
            int area= l*b;
            if (height[i] > height[j]) {
                j--;
            }else {
                i++;
            }
            if(area>maxw) maxw= area;
        }
        return maxw;
    }
}
