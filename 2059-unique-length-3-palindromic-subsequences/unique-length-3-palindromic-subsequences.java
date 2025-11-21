class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(first[ch-'a']==-1){
                first[ch-'a']=i;
            }
            last[ch-'a']=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(first[i]==-1||last[i]==-1){
                continue;
            }
            int st=first[i];
            int end=last[i];
            ArrayList<Character> ls=new ArrayList<>();
            for(int j=st+1;j<end;j++){
                if(!ls.contains(s.charAt(j))){
                    ls.add(s.charAt(j));
                }

            }
            ans+=ls.size();
        }
        return ans;
    }
}