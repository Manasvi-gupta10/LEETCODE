class Solution {
    public int maxLength(List<String> arr) {
        return concat(0,arr,"");
        
    }
    public int concat(int i,List<String> arr,String ans){
        int an=0;
       if(isunique(ans)){
            System.out.println(ans);
            an=Math.max(an,ans.length());
            
        }
        // if(i==arr.size()){
        //     return ans.length();
        // }
        
        for(int in=i;in<arr.size();in++){
            an=Math.max(an,concat(in+1,arr,ans+arr.get(in)));
            
        }
        return an;
    }
    public boolean isunique(String s){
        int[] fr=new int[26];
        for(int i=0;i<s.length();i++){
            fr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(fr[i]>1){
                return false;
            }
        }
        return true;
    }
}