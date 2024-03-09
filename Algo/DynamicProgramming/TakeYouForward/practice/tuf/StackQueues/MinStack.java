package StackQueues;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    int min;

    public static void main(String[] args) {
        MinStack minStack= new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min= minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

}
