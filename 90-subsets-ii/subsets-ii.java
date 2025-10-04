class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        subset(ans,ls,0,nums);
        return ans;
    }
    public void subset(List<List<Integer>> ans,List<Integer> ls,int in,int[] ar){
        ans.add(new ArrayList<>(ls));
        for(int i=in;i<ar.length;i++){
            if(i>in&&ar[i]==ar[i-1]){
                continue;
            }
            ls.add(ar[i]);
            subset(ans,ls,i+1,ar);
            ls.remove(ls.size()-1);
        }
    }
}