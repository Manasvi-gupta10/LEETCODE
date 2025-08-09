class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long ans=0;
        int j=n-1;
        int dec=1;
        for(int i=0;i<k;i++){
            ans+=happiness[j];
            if(j-1>=0){
                if(happiness[j-1]-dec<0){
                happiness[j-1]=0;
            }else{
                happiness[j-1]-=dec;
            }
            }
            j--;
            dec++;
        }
        return ans;

    }
}