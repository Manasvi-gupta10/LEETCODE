
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:map.keySet()){
            System.out.print(map.get(key));
            if(map.get(key)==1){
                return key;
            }
        }
        return 0;
    }
}