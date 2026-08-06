class MyQueue {
  Stack<Integer> s=new Stack<>();
         Stack<Integer> p=new Stack<>();
    public MyQueue() {
      
    }
    
    public void push(int x) {
      int size=s.size();
      for(int i=0;i<size;i++){
        p.push(s.peek());
        s.pop();
      }
      s.push(x);
    while (!p.isEmpty()) {
    s.push(p.pop());
}
        
    }
    
    public int pop() {
      return  s.pop();
    }
    
    public int peek() {
    return   s.peek(); 
    }
    
    public boolean empty() {
     return   s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */