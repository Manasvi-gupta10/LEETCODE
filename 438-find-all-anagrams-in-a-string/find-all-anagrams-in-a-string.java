class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int k=p.length();
        if(n<k){
            return ans;
        }
        
        
        if(isangram(s,p,0,k-1)){
            ans.add(0);
        }
        
        for(int i=k;i<n;i++){
            if(isangram(s,p,i-k+1,i)){
                ans.add(i-k+1);
            }

        }
        return ans;
    }
    public boolean isangram(String s,String p,int i,int j){
        int[] fr1=new int[26];
        int[] fr2=new int[26];
        for(int k=0;k<p.length();k++){
            fr1[p.charAt(k)-'a']++;
        }
        for(int k=i;k<=j;k++){
            fr2[s.charAt(k)-'a']++;
        }
        for(int k=0;k<26;k++){
            if(fr1[k]!=fr2[k]){
                return false;
            }
        }
        return true;
    }
}