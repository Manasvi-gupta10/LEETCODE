class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length;
        for(int i=0;i<len&&n>0;i++){
            if(flowerbed[i]==0){
                int prv=0,next=0;
                if(i>0){
                    prv=flowerbed[i-1];
                }
                if(i<len-1){
                    next=flowerbed[i+1];

                }
                if(prv==0&&next==0){
                    flowerbed[i]=1;
                    n--;

                }
            }
        }
        return n==0;
    }
}