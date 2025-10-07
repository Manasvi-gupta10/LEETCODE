class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int s1=maxp1(nums,0,n-1);
        int s2=total-s1;
        if(s1>=s2){
            return true;
        }
        return false;
    }
    public int maxp1(int[] ar,int i,int j){
        if(i>j){
            return 0;

        }
        int f=ar[i]+Math.min(maxp1(ar,i+2,j),maxp1(ar,i+1,j-1));
        int l=ar[j]+Math.min(maxp1(ar,i+1,j-1),maxp1(ar,i,j-2));
        return Math.max(f,l);
    }
}