class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int tot=0;
        for(int i=0;i<n;i++){
            tot+=nums[i];

        }
        if(tot%k!=0){
            return false;
        }else{
            int target=tot/k;
            boolean[] used=new boolean[n];
            return find(nums,target,0,k,0,used);
        }
    }
    public boolean find(int[] ar,int target,int i,int k,int cur,boolean[] used){
        if(k==1){
            return true;
        }
        if(cur==target){
            return find(ar,target,0,k-1,0,used);
        }
        for(int in=i;in<ar.length;in++){
            if(used[in]||ar[in]+cur>target){
                continue;
            }
            used[in]=true;
            if(find(ar,target,in+1,k,cur+ar[in],used)){
                return true;
            }
            used[in]=false;
            
        }
        return false;
        
    }
}