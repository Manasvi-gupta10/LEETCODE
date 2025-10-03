class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ar=new ArrayList<>();
        sum(candidates,target,ar,ans,0);
        return ans;
    }
    public void sum(int[] ar,int tar,List<Integer> li,List<List<Integer>> ans,int ind){
        if(tar==0){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=ind;i<ar.length;i++){
            if(i>ind&&ar[i]==ar[i-1]){
                continue;
            }
            if(tar>=ar[i]){
                li.add(ar[i]);
                sum(ar,tar-ar[i],li,ans,i+1);
                li.remove(li.size()-1);
            }
        }
    }
}