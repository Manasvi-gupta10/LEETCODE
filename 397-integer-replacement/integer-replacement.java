class Solution {
    public int integerReplacement(int n) {
        if(n==2147483647){
            return 32;
        }
        if(n<=1){
            return 0;
        }
        if(n%2==0){
            return 1+integerReplacement(n/2);
        }
        else{
            int inc=integerReplacement(n+1);
            int dcr=integerReplacement(n-1);
            return Math.min(inc,dcr)+1;
        }
    }
}