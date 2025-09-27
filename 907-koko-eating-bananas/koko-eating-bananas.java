class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
        long lo=1;
        long hi=piles[n-1];
        int ans=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isposs(mid,piles,h)){
                ans=(int)mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean isposs(long mid,int[] ar,int h){
        int hrs=0;
        for(int i=0;i<ar.length;i++){
            hrs+=Math.ceil((double)ar[i]/mid);
            
        }
        System.out.println(hrs);
        return hrs<=h;
    }
}