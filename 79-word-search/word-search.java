class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    boolean ans=find(board,word,i,j,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board,String word,int r,int c,int in){
        if(in==word.length()){
            return true;
        }
        if(r<0||c<0||r>=board.length||c>=board[0].length||word.charAt(in)!=board[r][c]){
            return false;
        }


        board[r][c]='.';
        int[] row={1,-1,0,0};
        int[] col={0,0,1,-1};
        for(int i=0;i<4;i++){
            boolean ans=find(board,word,r+row[i],c+col[i],in+1);
            if(ans==true){
                return true;
            }
        }
        board[r][c]=word.charAt(in);
        return false;
    }
}