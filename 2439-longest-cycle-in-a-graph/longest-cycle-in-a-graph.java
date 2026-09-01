class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int[] ind=new int[n];
        for(int i=0;i<n;i++){
            int v=edges[i];
            if(v==-1){
                continue;
            }
            ind[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        boolean[] visit=new boolean[n];
        while(!q.isEmpty()){
            int r=q.poll();
            visit[r]=true;
            int nb=edges[r];
            if(nb!=-1){
                ind[nb]--;
                if(ind[nb]==0){
                    q.add(nb);
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(visit[i]==true){
                continue;
            }
            visit[i]=true;
            int l=1;
            int nb=edges[i];
            while(nb!=i){
                l++;
                visit[nb]=true;
                nb=edges[nb];
            }
            ans=Math.max(ans,l);
        }
        return ans;
    }
}