class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gn=g.length;
        int sn=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans=0;
        int i=0,j=0;
        while(i<gn&&j<sn){
            if(s[j]>=g[i]){
                i++;
                j++;
                ans++;

            }
            else{
                j++;
            }
            
        }
        return ans;

    }
}