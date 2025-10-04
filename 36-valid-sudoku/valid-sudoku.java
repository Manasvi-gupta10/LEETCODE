class Solution {
    public boolean isValidSudoku(char[][] board) {
        return valid(board,0,0);
    }
    public boolean valid(char[][] board,int r,int c){
        if(c==9){
            r=r+1;
            c=0;
        }
        if(r==9){
            return true;
        }
        if(board[r][c]!='.'){
            if(safe(board,r,c)){
                return valid(board,r,c+1);
            }else{
                return false;
            }
        }else{
           return valid(board,r,c+1);
        }
        //return true;
    }
    public boolean safe(char[][] board,int r,int c){
        for(int i=0;i<board.length;i++){
            if(i==r){
                continue;
            }
            if(board[i][c]==board[r][c]){
                return false;
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(i==c){
                continue;
            }
            if(board[r][i]==board[r][c]){
                return false;
            }
        }
        int row=r-r%3;
        int col=c-c%3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(i==r&&j==c){
                    continue;
                }
                if(board[i][j]==board[r][c]){
                    return false;
                }
            }
        }
        return true;
    }

}