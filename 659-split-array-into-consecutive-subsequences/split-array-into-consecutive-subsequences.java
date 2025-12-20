class Solution {
    public boolean isPossible(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> fr=new HashMap<>();
        HashMap<Integer,Integer> need=new HashMap<>();
        for(int i=0;i<n;i++){
            fr.put(nums[i],fr.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(fr.get(nums[i])==0){
                continue;
            }
            if(need.getOrDefault(nums[i],0)>0){
                need.put(nums[i],need.get(nums[i])-1);
                need.put(nums[i]+1,need.getOrDefault(nums[i]+1,0)+1);
            }else if(fr.getOrDefault(nums[i]+1,0)>0&&fr.getOrDefault(nums[i]+2,0)>0){
                fr.put(nums[i]+1,fr.get(nums[i]+1)-1);
                fr.put(nums[i]+2,fr.get(nums[i]+2)-1);
                need.put(nums[i]+3,need.getOrDefault(nums[i]+3,0)+1);
            }else{
                return false;
            }
            fr.put(nums[i],fr.get(nums[i])-1);
        }
        return true;
    }
}