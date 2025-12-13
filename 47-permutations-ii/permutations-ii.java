class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        per2(nums,ans,ls,map);
        return ans;

        
    }
    public void per2(int[] nums,List<List<Integer>> ans,List<Integer> ls,HashMap<Integer,Integer> map){
        if(ls.size()==nums.length){
            ans.add(new ArrayList<>(ls));
        }
        for(int k:map.keySet()){
            if(map.get(k)>0){
                ls.add(k);
                map.put(k,map.get(k)-1);
                per2(nums,ans,ls,map);
                ls.remove(ls.size()-1);
                map.put(k,map.get(k)+1);
            }
        }
    }


    // public void per2(int[] nums,List<List<Integer>> ans,List<Integer> ls,List<Integer> idx){
    //     if(idx.size()==nums.length){
    //         if(!ans.contains(ls)){
    //             ans.add(new ArrayList<>(ls));
    //         }
    //         return;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(!idx.contains(i)){
    //             idx.add(i);
    //             ls.add(nums[i]);
    //             per2(nums,ans,ls,idx);
    //             ls.remove(ls.size()-1);
    //             idx.remove(idx.size()-1);
    //         }
    //     }
    // }
   
}