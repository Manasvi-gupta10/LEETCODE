class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int val=1;
            boolean f=false;
            while(val<=nums.get(i)&&!f){
                if((val|(val+1))==nums.get(i)){
                    ans[i]=val;
                    f=true;
                }
                val++;
            }
            if(!f){
                ans[i]=-1;
            }
        }
        return ans;
        
    }
}