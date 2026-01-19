class Solution {
    public int totalSteps(int[] nums) {
        int n=nums.length;
        Stack<int[]> st=new Stack<>();
        int ans=0;
        for(int i=n-1;i>=0;i--){
            int step=0;
            while(!st.isEmpty()&&nums[i]>st.peek()[0]){
                step=Math.max(step+1,st.pop()[1]);
            }
            ans=Math.max(ans,step);
            st.push(new int[]{nums[i],step});
        }
        return ans;
        
    }
}