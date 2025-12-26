class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=x;i<nums.size();i++){
            set.add(nums.get(i-x));
            Integer hi=set.ceiling(nums.get(i));
            Integer lo=set.floor(nums.get(i));
            if(hi!=null){
                ans=Math.min(ans,hi-nums.get(i));
            }
            if(lo!=null){
                ans=Math.min(ans,nums.get(i)-lo);
            }
        }
        return ans;
        
    }
}