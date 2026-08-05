import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q = new LinkedList<>();


    public MyStack() {
        
    }
    
   
    public void push(int x) {
        int size=q.size();
        q.add(x);
        for(int i=0;i<size;i++){
            q.add(q.peek());
            q.remove();
        }
    }
    
    

    public int pop() {
        return q.remove(); 
    }
    
    public int top() {
        return q.peek();
    }
    
   
    public boolean empty() {
        return q.isEmpty();
    }
}
