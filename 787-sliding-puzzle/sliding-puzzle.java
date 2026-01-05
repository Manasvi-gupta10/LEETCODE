class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directions=new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        String begin="";
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                begin+=board[i][j];
            }
        }
        String end="123450";
        HashSet<String> set=new HashSet<>();
        Queue<pair> q=new LinkedList<>();
        set.add(begin);
        q.add(new pair(begin,0));
        while(!q.isEmpty()){
            pair rp=q.poll();
            if(rp.s.equals(end)){
                return rp.moves;
            }
            char[] car=rp.s.toCharArray();
            int in=rp.s.indexOf('0');
            for(int i:directions[in]){
                swap(car,in,i);
                String change=new String(car);
                if(!set.contains(change)){
                    q.add(new pair(change,rp.moves+1));
                    set.add(change);
                }
                swap(car,i,in);
            }
        }
        return -1;
        
    }
    public void swap(char[] ar,int i,int j){
        char t=ar[i];
        ar[i]=ar[j];
        ar[j]=t;
    }
}
class pair{
    String s;
    int moves;
    public pair(String s,int moves){
        this.s=s;
        this.moves=moves;
    }
}