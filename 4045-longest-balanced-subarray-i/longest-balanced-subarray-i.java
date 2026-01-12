class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;
        
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> even=new HashMap<>();
        HashMap<Integer,Integer> odd=new HashMap<>();
            if(nums[i]%2==0){
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }else{
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }
            for(int j=i+1;j<n;j++){
                if(nums[j]%2==0){
                even.put(nums[j],even.getOrDefault(nums[j],0)+1);
            }else{
                odd.put(nums[j],odd.getOrDefault(nums[j],0)+1);
            }
            if(even.size()==odd.size()){
                ans=Math.max(ans,j-i+1);
            }
            }
        }   
        return ans;
    }
}