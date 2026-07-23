class Solution {
    public boolean lemonadeChange(int[] bills) {
        int drawer5= 0;
        int drawer10=0;
        for(int i=0; i<bills.length; i++){
            if(bills[i]==5){
                drawer5++;
            }else{
                if(bills[i]==10){
                    if(drawer5==0) return false;
                    drawer5--;
                    drawer10++;
                }
                if(bills[i]==20){
                    if((drawer5<3) && (drawer10==0)||(drawer5==0 && drawer10!=0)) return false;
                    if(drawer10 !=0){
                        drawer10--;
                        drawer5--;
                    }else{
                        drawer5= drawer5-3;
                    }

                }
            }
        }
        return true;
    }
}
