class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ls=new ArrayList<>();
        ipadd(s,0,ls,"");
        return ls;
        
    }
    public void ipadd(String s,int i,List<String> ls,String ans){
        if(i==s.length()){
            ans=ans.substring(0,ans.length()-1);
            if(ans.length()==s.length()+3){
                ls.add(ans);
            }
            return;
        }

        for(int in=i+1;in<=i+3&&in<=s.length();in++){
            String sub=s.substring(i,in);
            if(sub.length()>1&&sub.charAt(0)=='0'){
                continue;
            }
            int n=Integer.parseInt(sub);
            if(n>=0&&n<=255){
                ipadd(s,in,ls,ans+sub+".");
            }

        }
    }
}