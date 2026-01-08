class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> ls=new ArrayList<>();
        int i=1;
        while(i*i<=n){
            ls.add(i*i);
            i++;
        }
        
        return min(ls,n);
        
    }
    public int min(ArrayList<Integer> ls, int tar) {

    int INF = 1000000000;
    int[][] dp = new int[tar + 1][ls.size() + 1];

    // base case
    for (int i = 1; i <= tar; i++) {
        dp[i][0] = INF;
    }

    for (int i = 1; i <= tar; i++) {
        for (int j = 1; j <= ls.size(); j++) {

            int an1 = INF;
            int val = ls.get(j - 1);

            // TAKE (unbounded → j stays same)
            if (i - val >= 0 && dp[i - val][j] != INF) {
                an1 = dp[i - val][j] + 1;
            }

            // NOT TAKE
            int an2 = dp[i][j - 1];

            dp[i][j] = Math.min(an1, an2);
        }
    }

    return dp[tar][ls.size()] >= INF ? -1 : dp[tar][ls.size()];
}

}