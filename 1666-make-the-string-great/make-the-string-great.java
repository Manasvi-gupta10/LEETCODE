class Solution {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder(s);
        int n=s.length();
        int i=0;
        while(i<sb.length()-1){
            if((sb.charAt(i)==sb.charAt(i+1)+32)||(sb.charAt(i)==sb.charAt(i+1)-32)){
                sb.deleteCharAt(i+1);
                sb.deleteCharAt(i);
                
                if(i>0){
                    i=i-1;
                }
            }
            else{
                
                i++;
            }
        }return sb.toString();
    }
}