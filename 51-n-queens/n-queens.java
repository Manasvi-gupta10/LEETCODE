class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        String[][] ar=new String[n][n];
        placed(ar,0,n,ans);
        return ans;
    }
    public void placed(String[][] ar,int r,int tq,List<List<String>> ans){
        
        if(tq==0){
            ArrayList<String> li=display(ar);
            ans.add(li);
            return;
        }

        for(int i=0;i<ar[0].length;i++){
            if(issafe(ar,r,i)){
                ar[r][i]="Q";
                
                placed(ar,r+1,tq-1,ans);
                ar[r][i]=".";
                
            }
        }
    }
    public ArrayList<String> display(String[][] ar){
        ArrayList<String> ls=new ArrayList<>();
        for(int i=0;i<ar[0].length;i++){
            StringBuilder ans=new StringBuilder();
            for(int j=0;j<ar[0].length;j++){
                if(ar[i][j]=="Q"){
                    ans.append("Q");
                }else{
                    ans.append(".");
                }
            }
            ls.add(ans.toString());
        }
        return ls;
    }
    public boolean issafe(String[][] ar,int r,int i){
        int row=r;
        int col=i;
        while(row>=0){
            if(ar[row][col]=="Q"){
                return false;
            }
            row--;
        }
        row=r;
        while(col>=0&&row>=0){
            if(ar[row][col]=="Q"){
                return false;
            }
            row--;
            col--;
        }
        row=r;
        col=i;
        while(col<ar[0].length&&row>=0){
            if(ar[row][col]=="Q"){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
}