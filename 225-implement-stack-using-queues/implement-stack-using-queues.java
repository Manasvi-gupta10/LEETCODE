class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    public int pop() {
         if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // move all except last element from q1 -> q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // last remaining is the top element of the stack
        int top = q1.remove();

        // swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
    
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // move all except last element
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.peek(); // just peek
        q2.add(q1.remove()); // move last element too (don’t lose it)

        // swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */