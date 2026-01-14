class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int maxOperations(int[] nums) {
        return max(nums,0,nums.length-1,-1);
        
    }
    public  int max(int[] nums,int st,int end,int prev){
        if(st>=end){
            return 0;
        }

        String key=st+" "+end+" ";
        if(map.containsKey(key)){
            return map.get(key);
        }

        int ans=0;
        int sum1=nums[st]+nums[st+1];
        if(prev==-1||sum1==prev){
            ans=Math.max(ans,1+max(nums,st+2,end,sum1));
        }
        int sum2=nums[end]+nums[end-1];
        if(prev==-1||sum2==prev){
            ans=Math.max(ans,1+max(nums,st,end-2,sum2));
        }
        int sum3=nums[st]+nums[end];
        if(prev==-1||sum3==prev){
            ans=Math.max(ans,1+max(nums,st+1,end-1,sum3));
        }
        map.put(key,ans);
        return ans;
    }
}