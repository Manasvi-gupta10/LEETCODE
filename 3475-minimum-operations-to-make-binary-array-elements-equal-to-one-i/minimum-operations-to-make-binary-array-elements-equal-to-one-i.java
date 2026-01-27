class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Queue<Integer> q=new LinkedList<>();//store ho rhi active flips jo chl rhi wo kis index p end ho rhi
        int ans=0;
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&q.peek()<i){//flips jo phle end hongi ith se wo ith wle k kaam ki nii toh htado
                q.poll();
            }
            int cur=nums[i];
//Queue ka size yeh batata hai ki ith element par kitne flips currently apply ho rahe hain..if odd toh wo usse change kr dega agr even toh jo hai whi rhega
            if(q.size()%2!=0){
                cur^=1;
            }
            if(cur==0){
                if(i+2>=n){//ith wla 0 hogya pr aage 3 elm hai hi ni toh flip possible ni 
                    return -1;
                }
                ans++;
            q.add(i+2);
            }
            
        }
        return ans;
    }
}