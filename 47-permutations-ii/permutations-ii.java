class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        List<Integer> idx=new ArrayList<>();
        per2(nums,ans,ls,idx);
        return ans;

        
    }
    public void per2(int[] nums,List<List<Integer>> ans,List<Integer> ls,List<Integer> idx){
        if(idx.size()==nums.length){
            if(!ans.contains(ls)){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!idx.contains(i)){
                idx.add(i);
                ls.add(nums[i]);
                per2(nums,ans,ls,idx);
                ls.remove(ls.size()-1);
                idx.remove(idx.size()-1);
            }
        }
    }
   
}