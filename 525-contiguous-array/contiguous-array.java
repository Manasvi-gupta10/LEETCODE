class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int[] ar=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum-=1;

            }else{
                sum+=1;
            }
            ar[i]=sum;
        }
       HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
       for(int i=0;i<n;i++){
         if(!map.containsKey(ar[i])){
            map.put(ar[i],new ArrayList<>());
         }
         map.get(ar[i]).add(i);
       }
       int ans=0;
       for(int k:map.keySet()){
        int sz=map.get(k).size();
        if(k==0){
            ans=Math.max(ans,map.get(k).get(sz-1)+1);
        }else{
            ans=Math.max(ans,map.get(k).get(sz-1)-map.get(k).get(0));
        }
       }
       return ans;



    }
}