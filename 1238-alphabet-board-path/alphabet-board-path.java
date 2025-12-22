class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans=new StringBuilder();
        int r=0,c=0;
        for(int i=0;i<target.length();i++){
            char ch=target.charAt(i);
            int tr=(ch-'a')/5;
            int tc=(ch-'a')%5;
            while(c>tc){
                ans.append('L');
                c--;
            }
            while(r>tr){
                ans.append('U');
                r--;
            }
            while(r<tr){
                ans.append('D');
                r++;
            }
            
            
            while(c<tc){
                ans.append('R');
                c++;
            }
            ans.append('!');
        }
        return ans.toString();
        
    }
}