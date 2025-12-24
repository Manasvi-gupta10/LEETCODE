class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        if(n1!=n2){
            return false;
        }
        int[] fr=new int[26];
        int[] fr1=new int[26];
        for(int i=0;i<n1;i++){
            fr[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<n2;i++){
            fr1[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if((fr[i]==0&&fr1[i]!=0)||fr[i]!=0&&fr1[i]==0){
                return false;
            }

        }
        Arrays.sort(fr);
        Arrays.sort(fr1);
        for(int i=0;i<26;i++){
            if(fr[i]!=fr1[i]){
                return false;
            }
        }
        return true;
        
    }
}