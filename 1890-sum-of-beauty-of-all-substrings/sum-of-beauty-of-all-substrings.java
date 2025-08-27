
class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int[] fr=new int[26];
                for(int k=i;k<j;k++){
                    fr[s.charAt(k)-'a']++;
                }
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(fr[k]==0){//0 mtlb jo aye hi ni toh min m aakte isiliye ni liya
                        continue;
                    }
                   max=Math.max(max,fr[k]);
                   min=Math.min(min,fr[k]);
                }
                ans+=(max-min);
			}
		}
        return ans;
    }
}