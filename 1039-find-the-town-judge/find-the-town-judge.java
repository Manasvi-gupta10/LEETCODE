class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] isjudge=new boolean[n+1];
        for(int i=0;i<trust.length;i++){
            isjudge[trust[i][0]]=true;
        }
        int pos=0;
        for(int i=1;i<=n;i++){
            if(isjudge[i]==false){
                pos=i;
                break;
            }
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==pos){
                ls.add(trust[i][0]);
            }
        }
        if(ls.size()==n-1){
            return pos;
        }
        return -1;
    }
}