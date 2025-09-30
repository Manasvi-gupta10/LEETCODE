class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[i]<heights[st.peek()]){
                int h=heights[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    ans=Math.max(ans,h*r);
                }else{
                    int l=st.peek();
                    ans=Math.max(ans,h*(r-l-1));
                }
            }
            st.push(i);
        }
        int r=n;
        while(!st.isEmpty()){
            int h=heights[st.pop()];
            if(st.isEmpty()){
                ans=Math.max(ans,h*r);
            }else{
                int l=st.peek();
                    ans=Math.max(ans,h*(r-l-1));
            }
        }
        return ans;
    }
}