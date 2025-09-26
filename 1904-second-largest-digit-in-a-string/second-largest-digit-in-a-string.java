class Solution {
    public int secondHighest(String s) {
       
        int n=s.length();
        int mx=-1;
        int smx=-2;

        for(int i=0;i<n;i++){
            if(s.charAt(i)>=48&&s.charAt(i)<=57){
                int val=s.charAt(i)-'0';
                if(val>mx){
                    smx=mx;
                    mx=val;
                }else if(val>smx&&val<mx){
                    smx=val;
                }

                }
               
            }
            //System.out.println(Integer.MIN_VALUE);
        if(smx==-2){
            return -1;
        }
        return smx;
        
    }
}