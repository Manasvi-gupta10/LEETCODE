class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        perm(nums,ans,ls);
        return ans;
    }
    public void perm(int[] ar,List<List<Integer>> ans,List<Integer> ls){
       if(ls.size()==ar.length){
         ans.add(new ArrayList<>(ls));
         return;
       }
       for(int i=0;i<ar.length;i++){
         if(!ls.contains(ar[i])){
            ls.add(ar[i]);
            perm(ar,ans,ls);
            ls.remove(ls.size()-1);
         }
       }
    }
}