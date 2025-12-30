class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] mind1=mindis(edges,node1);
        int[] mind2=mindis(edges,node2);
        int node=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mind1.length;i++){
            if(mind1[i]==-1||mind2[i]==-1){
                continue;
            }
            int mn=Math.max(mind1[i],mind2[i]);
            if(mn<ans){
                ans=mn;
                node=i;
            }
        }
        return node;
        
    }
    public int[] mindis(int[] edges,int nd){
        int[] mind=new int[edges.length];
        Arrays.fill(mind,-1);
        int d=0;
        int cur=nd;
        while(cur!=-1&&mind[cur]==-1){
            mind[cur]=d;
            cur=edges[cur];
            d++;
        }
        return mind;

    }
}