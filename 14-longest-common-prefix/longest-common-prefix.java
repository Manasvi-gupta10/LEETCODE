class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n==1){
            return strs[0];

        }
        String p=pref(strs[0],strs[1]);
        if(p.length()==0){
            return p;
        }
        for(int i=2;i<n;i++){
            p=pref(p,strs[i]);
        }
        return p;
        
    }
    public String pref(String s1,String s2){
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                sb.append(s1.charAt(i));
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}