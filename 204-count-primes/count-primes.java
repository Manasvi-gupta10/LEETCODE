class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;

        }
        return prime(n);
    }
    public int prime(int n){
        int[] ar=new int[n];
        ar[0]=ar[1]=1;
        for(int i=2;i*i<=n;i++){
            if(ar[i]==0){
                for(int j=2;j*i<n;j++){
                    ar[j*i]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ar[i]==0){
                count++;
            }
        }
        return count;
    }
}