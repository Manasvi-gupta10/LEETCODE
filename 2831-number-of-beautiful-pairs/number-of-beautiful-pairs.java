class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(beautiful(nums[i],nums[j])){
                    ans++;
                }
            }
        }
        return ans;
        
    }
    public boolean beautiful(int n,int m){
        if(m>=10){
            m=m%10;
        }
        int r=n;
        if(n>=10){
            while(n>0){
                r=n%10;
                n=n/10;
            }
        }
        int gcd=1;
        for(int i=1;i<=Math.min(m,r);i++){
            if(m%i==0&&r%i==0){
                gcd=i;
            }
        }
        return gcd==1;
    }
}