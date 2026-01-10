class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            int p=arr[i]-difference;
            int len=map.getOrDefault(p,0)+1;
            ans=Math.max(ans,len);
            map.put(arr[i],len);
        }
        return ans;
    }
}