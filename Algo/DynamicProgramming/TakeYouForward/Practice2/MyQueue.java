import java.util.Stack;

class MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
    
    Stack<Integer> stack1,stack2;
    int size;

    public MyQueue() {
        stack1= new Stack<>();
        stack2= new Stack<>();
        size=0;
    }
    
    public void push(int x) {
        stack1.push(x);
        size++;
    }
    
    public int pop() {
        if(empty()) return -1;
        
        for(int i=0;i<size-1;i++) stack2.push(stack1.pop());
        size--;
        int i = stack1.pop();
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return i;
    }
    
    public int peek() {
        if(empty()) return -1;
        for(int i=0;i<size-1;i++) stack2.push(stack1.pop());
        int i = stack1.pop();
        stack2.push(i);
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return i;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

