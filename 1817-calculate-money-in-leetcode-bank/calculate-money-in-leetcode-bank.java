class Solution {
    public int totalMoney(int n) {
        int w=(int)Math.ceil(n/7);
        int day=0;
        int ans=0;
        int i=0;
        int j=0;
        while(day<n){
            if(day%7==0){
                i++;
                j=i;
            }
            ans+=j;
            j++;
            day++;
        }
        return ans;
    }
}