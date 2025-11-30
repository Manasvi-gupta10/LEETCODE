class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] ind=new int[n];
        int sz=edges.size();
        for(int i=0;i<sz;i++){
            ind[edges.get(i).get(1)]++;
        }
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}