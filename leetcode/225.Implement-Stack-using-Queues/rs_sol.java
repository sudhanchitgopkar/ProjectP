class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    } // Constructor
    
    public void push(int x) {
        q.offer(x);
    } // push
    
    public int pop() {
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        } // if

        return q.poll();
    } // pop
    
    public int top() {
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        } // if

        int ret = q.poll();        
        q.offer(ret);
        return ret;
    } // top
    
    public boolean empty() {
        return q.isEmpty();
    } // empty
} // MyStack