class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int m=arr2.length;
        int ex1=0,ex2=0;
        for(int i=0;i<n;i++){
            ex1^=arr1[i];
        }
        for(int i=0;i<m;i++){
            ex2^=arr2[i];
        }
        return ex1&ex2;
    }
}