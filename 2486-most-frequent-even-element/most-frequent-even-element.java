
class Solution {
    public int mostFrequentEven(int[] nums) {
      

        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(nums[i]%2==0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        if(map.isEmpty()){
            return -1;
        }
        int e=Integer.MAX_VALUE;
        int f=Collections.max(map.values());
        for(int k:map.keySet()){
            if(map.get(k)==f){
                e=Math.min(e,k);
            }
        }
       
        return e;
    }
}