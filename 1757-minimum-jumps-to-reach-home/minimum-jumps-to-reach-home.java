class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int n=forbidden.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(forbidden[i]);
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,0));
        boolean[][] visit=new boolean[6001][2];
        visit[0][0]=true;
        while(!q.isEmpty()){
            pair rp=q.poll();
            if(rp.pos==x){
                return rp.steps;
            }
            int f=rp.pos+a;
            if(f<6001&&!set.contains(f)&&!visit[f][0]){
                visit[f][0]=true;
                q.add(new pair(f,rp.steps+1,0));
            }
            int back=rp.pos-b;
            if(rp.prevstate==0&&back>=0&&!set.contains(back)&&!visit[back][1]){
                visit[back][1]=true;
                q.add(new pair(back,rp.steps+1,1));
            }
        }
        return -1;

        
    }
}
class pair{
    int pos;
    int steps;
    int prevstate;//0-> pichli bar forward se aye the    1->pichi=li bar backward se
    public pair(int pos,int steps,int prevstate){
        this.pos=pos;
        this.steps=steps;
        this.prevstate=prevstate;
    }
}