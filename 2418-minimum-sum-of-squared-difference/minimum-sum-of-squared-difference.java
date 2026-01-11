class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int[] dif=new int[n];
        int maxdif=0;
        for(int i=0;i<n;i++){
            dif[i]=Math.abs(nums1[i]-nums2[i]);
            maxdif=Math.max(maxdif,dif[i]);
        }
        int k=k1+k2;
        int[] fr=new int[maxdif+1];
        for(int i=0;i<n;i++){
            fr[dif[i]]++;
        }
        for(int d=maxdif;d>0&&k>0;d--){
            if(fr[d]==0){
                continue;
            }
            int mv=Math.min(k,fr[d]);
            fr[d]-=mv;
            fr[d-1]+=mv;
            k-=mv;

        }
        long ans=0;
        for(int i=0;i<fr.length;i++){
            ans+=fr[i]*(long)i*i;
        }
        return ans;
        
    }
}