class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int prevsmall=0,prevlarge=0,nextsmall=0,nextlarge=0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    prevsmall++;
                }else if(rating[j]>rating[i]){
                    prevlarge++;
                }
            }
            for(int j=i+1;j<n;j++){
                 if(rating[j]<rating[i]){
                    nextsmall++;
                }else if(rating[j]>rating[i]){
                    nextlarge++;
                }
            }
            ans+=prevsmall*nextlarge;
            ans+=prevlarge*nextsmall;
        }
        return ans;
    }
}