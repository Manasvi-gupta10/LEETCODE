class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int lo=1;
        int hi=tasks.length;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int[] sessions=new int[mid];
            if(ispos(tasks,sessionTime,sessions,0)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean ispos(int[] ar,int ses,int[] sessions,int i){
        if(i>=ar.length){
            return true;
        }
        for(int in=0;in<sessions.length;in++){
            if(ar[i]+sessions[in]<=ses){
                sessions[in]+=ar[i];
                if(ispos(ar,ses,sessions,i+1)){
                    return true;
                }
                sessions[in]-=ar[i];
            }
            if(sessions[in]==0){
                break;
            }
            
        }
        return false;
    }
}