class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length()<3){
            return false;
        }
        int a=0,b=0;
        for(int i=1;i<colors.length()-1;i++){
            char left=colors.charAt(i-1);
            char right=colors.charAt(i+1);
            char cur=colors.charAt(i);
            if(cur=='A'&&cur==left&&left==right){
                a++;
               
            }
            else if(cur=='B'&&cur==left&&left==right){
                b++;
               
            }
        }
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
}