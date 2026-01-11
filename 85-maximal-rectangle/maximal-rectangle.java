class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] ar=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    ar[j]=0;
                }else{
                    ar[j]++;
                }
            }
            ans=Math.max(ans,maxarea(ar));
        }
        return ans;
        
    }
    public int maxarea(int[] ar){
        Stack<Integer> st=new Stack<>();
        int n=ar.length;
        int ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&ar[st.peek()]>ar[i]){
                int h=ar[st.pop()];
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
            int h=ar[st.pop()];
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