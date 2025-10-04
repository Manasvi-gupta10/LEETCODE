class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        comb(ans,ls,candidates,target,0);
        return ans;
    }
    public void comb(List<List<Integer>> ans,List<Integer> ls,int[] ar,int target,int in){
        if(target==0){
            ans.add(new ArrayList<>(ls));
            return;
        }


        for(int i=in;i<ar.length;i++){
            if(target>=ar[i]){
                ls.add(ar[i]);
                comb(ans,ls,ar,target-ar[i],i);
                ls.remove(ls.size()-1);

            }
        }
    }
}