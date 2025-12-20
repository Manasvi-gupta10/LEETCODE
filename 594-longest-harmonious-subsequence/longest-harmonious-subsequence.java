class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ls=new ArrayList<>(map.keySet());
        int mx=0;
        for(int i=1;i<ls.size();i++){
            if(ls.get(i-1)+1==ls.get(i)){
                mx=Math.max(mx,map.get(ls.get(i-1))+map.get(ls.get(i)));
            }
        }
        return mx;
    }
}