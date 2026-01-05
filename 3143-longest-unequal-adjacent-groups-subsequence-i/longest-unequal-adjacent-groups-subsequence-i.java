class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<n;i++){
            if(groups[i-1]!=groups[i]){
                ans.add(words[i]);
                
                
            }
        }
        return ans;
        
    }
}