class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                in[edges[i]]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        boolean[] visited=new boolean[n];
        while(!q.isEmpty()){
            int r=q.poll();
            visited[r]=true;
            if(edges[r]!=-1){
                in[edges[r]]--;
                if(in[edges[r]]==0){
                    q.add(edges[r]);
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                int c=1;
                visited[i]=true;
                int nb=edges[i];
                while(nb!=i){
                    c++;
                    visited[nb]=true;
                    nb=edges[nb];
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}