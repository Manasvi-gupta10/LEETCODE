class Solution {
    public int totalNQueens(int n) {
        String[][] ar=new String[n][n];
        return placed(ar,0,n);
    }
    public int placed(String[][] ar,int r,int tq){
        
        if(tq==0){
            
            return 1;
        }
        int tot=0;
        for(int i=0;i<ar[0].length;i++){
            if(issafe(ar,r,i)){
                ar[r][i]="Q";
                
                tot+=placed(ar,r+1,tq-1);
                ar[r][i]=".";
                
            }
        }
        return tot;
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