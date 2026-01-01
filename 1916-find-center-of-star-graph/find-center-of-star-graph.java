class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        ArrayList<Integer> ls=new ArrayList<>();
        ls.add(edges[0][0]);
        ls.add(edges[0][1]);
        int ans=0;
        for(int i=1;i<n;i++){
            if(ls.contains(edges[i][0])){
                ans=edges[i][0];
            }
            if(ls.contains(edges[i][1])){
                ans=edges[i][1];
            }
        }
        return ans;
        
    }
}