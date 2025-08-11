class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n=time.length;
        long lo=1;
        long hi=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            hi=Math.min(hi,(long)time[i]);
        }
        hi=hi*totalTrips;
        long ans=0;
        while(lo<=hi){
            long mid=(lo+hi)/2;
            if(ispos(time,mid,totalTrips)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean ispos(int[] ar,long t,int tottrip){
        long com=0;
        for(int i=0;i<ar.length;i++){
             com+=t/ar[i];
            if(com>=tottrip){
                return true;
            }
        }
        return com>=tottrip;

    }
}