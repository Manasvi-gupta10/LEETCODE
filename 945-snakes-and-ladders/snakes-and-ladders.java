class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<pair> q=new LinkedList<>();
        boolean[] visit=new boolean[n*n+1];
        visit[1]=true;
        q.add(new pair(1,0));
        while(!q.isEmpty()){
            pair r=q.poll();
            int cell=r.cell;
            int moves=r.moves;
            for(int i=1;i<=6;i++){
                int next=cell+i;
                if(next>n*n){
                    continue;
                }
                int nextcell=newcell(board,n,next);
                if(nextcell==n*n){
                    return moves+1;
                }
                if(!visit[nextcell]){
                    visit[nextcell]=true;
                    q.add(new pair(nextcell,moves+1));
                }
            }
        }
        return -1;
    }
    public int newcell(int[][] ar,int n,int next){
        int row=(next-1)/n;
        int col=(next-1)%n;
        if(row%2!=0){
            col=n-1-col;
        }
        int val=ar[n-1-row][col];
        return val==-1?next:val;
    }
}
class pair{
    int cell;
    int moves;
    public pair(int cell,int moves){
        this.cell=cell;
        this.moves=moves;
    }
}