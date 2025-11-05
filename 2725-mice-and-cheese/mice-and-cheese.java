class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n=reward1.length;
        int tot=0;
        for(int i=0;i<n;i++){
            tot+=reward2[i];
        }
        if(k==0){
            return tot;
        }
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=reward1[i];
            ar[i][1]=reward2[i];

        }
        Arrays.sort(ar,(a,b)->((b[0]-b[1])-(a[0]-a[1])));
        int i=0;
        while(i<n&&k>0){
            tot-=ar[i][1];
            tot+=ar[i][0];
            i++;
            k--;
        }
        return tot;
    }
}