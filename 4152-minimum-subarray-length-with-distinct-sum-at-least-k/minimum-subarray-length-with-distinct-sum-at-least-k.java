class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        int si=0,ei=0;
        int sum=0;

        while(ei<n){
            if(!map.containsKey(nums[ei])){
                sum+=nums[ei];

            }
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
            while(si<=ei&&sum>=k){
                ans=Math.min(ans,ei-si+1);
                map.put(nums[si],map.get(nums[si])-1);
                if(map.get(nums[si])==0){
                    sum-=nums[si];
                    map.remove((nums[si]));
                }
                si++;

            }
            ei++;

        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}