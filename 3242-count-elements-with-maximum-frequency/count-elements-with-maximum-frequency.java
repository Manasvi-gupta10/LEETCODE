class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(int k:map.keySet()){
            max=Math.max(max,map.get(k));
        }
        int ans=0;
        for(int k:map.keySet()){
            if(map.get(k)==max){
                ans+=map.get(k);
            }
        }
        return ans;
    }
}