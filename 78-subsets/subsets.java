class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        subset(nums,0,ans,ls);
        return ans;
    }
    public void subset(int[] ar,int in,List<List<Integer>> an,List<Integer> ls){
        an.add(new ArrayList<>(ls));
        for(int i=in;i<ar.length;i++){
            ls.add(ar[i]);
            subset(ar,i+1,an,ls);
            ls.remove(ls.size()-1);
        }
    }
}