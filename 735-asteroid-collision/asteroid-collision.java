class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            boolean isdestroy=false;
            while(!st.isEmpty()&&st.peek()>0&&asteroids[i]<0){
                if(Math.abs(st.peek())<Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                if(Math.abs(st.peek())==Math.abs(asteroids[i])){
                    st.pop();
                }
                isdestroy=true;
                break;
            }
            if(!isdestroy){
                st.push(asteroids[i]);
            }
        }
        System.out.println(st);
        int[] ans=new int[st.size()];
        int j=st.size()-1;
        while(j>=0){
            ans[j]=st.pop();
            j--;
        }
        return ans;
    }
}