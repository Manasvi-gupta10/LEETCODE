class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int lo=0;
        int hi=queries.length;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(ispos(nums,queries,mid)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean ispos(int[] ar,int[][] q,int k){
        int n=ar.length;
        for(int i=0;i<n;i++){
            if(ar[i]==0){
                continue;
            }
            int tar=ar[i];
            ArrayList<Integer> ls=new ArrayList<>();
            for(int j=0;j<k;j++){
                int l=q[j][0];
                int r=q[j][1];
                if(l<=i&&r>=i){
                    ls.add(q[j][2]);
                }
            }
            
            if(!made(ls,tar)){
                return false;
            }
        }
        return true;
    }
    public boolean made(ArrayList<Integer> ls,int tar){
        Boolean[][] dp=new Boolean[tar+1][ls.size()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=false;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean in=false,ex=false;
                if(i-ls.get(j-1)>=0){
                    in=dp[i-ls.get(j-1)][j-1];
                }
                ex=dp[i][j-1];
                dp[i][j]=in||ex;
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }
}