class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int l=1;
        Arrays.sort(nums);
        int ans=0;
        int h=nums[n-1];
        while(l<=h){
            int mid=(l+h)/2;
            if(pos(nums,threshold,mid)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
    }
    public boolean pos(int[] ar,int th,int d){
        int s=0;
        for(int i=0;i<ar.length;i++){
            s+=(int)Math.ceil((double)ar[i] / d);

           
        }
        return s<=th;
    }
}