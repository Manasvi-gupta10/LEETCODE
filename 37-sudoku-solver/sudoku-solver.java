class Solution {
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
    public boolean solver(char[][] ar,int r,int c){
        if(c==9){
            r++;
            c=0;
        }
        if(r==9){
            return true;
        }

        if(ar[r][c]!='.'){
            return solver(ar,r,c+1);
        }else{
            for(int v=1;v<=9;v++){
                if(safe(ar,r,c,v)){
                    ar[r][c]=(char)(v+'0');
                    if(solver(ar,r,c+1)){
                        return true;
                    }
                    ar[r][c]='.';
                }
            }
        }
        return false;
    }
    public boolean safe(char[][] ar,int r,int c,int v){

        for(int i=0;i<ar.length;i++){
            if(ar[i][c]==(char)(v+'0')){
                return false;
            }
        }
        for(int i=0;i<ar[0].length;i++){
            if(ar[r][i]==(char)(v+'0')){
                return false;
            }
        }
        r=r-r%3;
        c=c-c%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(ar[i][j]==(char)(v+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}