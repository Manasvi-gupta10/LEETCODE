class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];
        int[] dif=new int[n+2];
        int ln=bookings.length;
        for(int i=0;i<ln;i++){
            dif[bookings[i][0]]+=bookings[i][2];
            dif[bookings[i][1]+1]-=bookings[i][2];
        }
        int sum=dif[1];
        for(int i=1;i<=n;i++){
            ans[i-1]=sum;
            sum+=dif[i+1];
        }
        return ans;
    }
}