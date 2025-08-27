class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int m=queries.length;
        int[] ans=new int[m];
        int[] pre=new int[n];
        ArrayList<Character> vowels=new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        if((vowels.contains(words[0].charAt(0)))&&vowels.contains(words[0].charAt(words[0].length()-1))){
            pre[0]=1;
        }
        for(int i=1;i<n;i++){
            if((vowels.contains(words[i].charAt(0)))&&vowels.contains(words[i].charAt(words[i].length()-1))){
            pre[i]=pre[i-1]+1;
        }else{
            pre[i]=pre[i-1];
        }

        }
        for(int i=0;i<m;i++){
            int s=queries[i][0];
            int e=queries[i][1];
            if(s!=0){
                ans[i]=pre[e]-pre[s-1];
            }
            else{
                ans[i]=pre[e];
            }
        }
        return ans;
    }
}