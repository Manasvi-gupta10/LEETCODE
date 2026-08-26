class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;
        int maxl=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rm=sum%k;
            if(rm<0){
                rm+=k;
            }
            if(map.containsKey(rm)){
                int l=i-map.get(rm);
                maxl=Math.max(maxl,l);
            }else{
                map.put(rm,i);
            }
           
        }
        if(maxl>=2){
            return true;
        }
        return false;
    }
}