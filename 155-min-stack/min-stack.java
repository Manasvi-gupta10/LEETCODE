class MinStack {
    Stack<Integer> st;
    int min;
    public MinStack() {
        st=new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        min=Math.min(min,val);
    }
    
    public void pop() {
        int e=st.pop();
        if(min==e){
            min=Integer.MAX_VALUE;
        }
        for(int v:st){
            min=Math.min(min,v);
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */