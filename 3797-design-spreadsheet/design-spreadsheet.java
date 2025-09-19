class Spreadsheet {
    int[][] mat;
    public Spreadsheet(int rows) {
        mat=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int c=cell.charAt(0)-'A';
        int r=Integer.parseInt(cell.substring(1))-1;
        mat[r][c]=value;
    }
    
    public void resetCell(String cell) {
        int c=cell.charAt(0)-'A';
        int r=Integer.parseInt(cell.substring(1))-1;
        mat[r][c]=0;
    }
    
    public int getValue(String formula) {
        String[] com=formula.substring(1).split("\\+");
        int ans=0;
        for(int i=0;i<com.length;i++){
            if(Character.isLetter(com[i].charAt(0))){
                int c=com[i].charAt(0)-'A';
                int r=Integer.parseInt(com[i].substring(1))-1;
                ans+=mat[r][c];
            }else{
                ans+=Integer.parseInt(com[i]);
            }
        }
        return ans;

    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */