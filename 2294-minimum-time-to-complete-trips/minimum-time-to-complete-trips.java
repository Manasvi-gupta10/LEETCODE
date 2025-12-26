class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long lo=1;
        int n=time.length;
        long hi=(long)time[0]*totalTrips;
        long ans=0;
        
        
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(ispos(time,totalTrips,mid)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;

        

    }
    public boolean ispos(int[] ar,int tr,long tm){
        long ct=0;
        for(int i=0;i<ar.length;i++){
            ct+=tm/ar[i];
            if(ct>=tr){
                return true;
            }
        }
        return ct>=tr;
    }
}