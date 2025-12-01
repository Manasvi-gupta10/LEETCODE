class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long lo=0;
        long hi=0;
        int len=batteries.length;
        for(int i=0;i<len;i++){
            hi+=batteries[i];
        }
        long ans=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(ispos(mid,n,batteries)){
                ans=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return ans;

    }
    public boolean ispos(long mid,int n,int[] ar){
        long s=0;
        for(int i=0;i<ar.length;i++){
            s+=Math.min(mid,ar[i]);//mid se km toh utna use krlo us battery else mid jitni hi
        }
        if(s>=n*mid){
            return true;
        }else{
            return false;
        }
    }

}