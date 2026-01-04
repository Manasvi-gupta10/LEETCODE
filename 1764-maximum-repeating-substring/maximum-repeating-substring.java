class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans=0;
        String t=word;
        while(sequence.contains(t)){
            ans++;
            t+=word;
        }
        return ans;
    }
}