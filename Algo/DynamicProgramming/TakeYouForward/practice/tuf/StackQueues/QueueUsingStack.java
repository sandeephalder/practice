package StackQueues;


public class QueueUsingStack<T> {
    Stack<T> stack1 = null,stack2 = null;
    public static void main(String[] args) {
        QueueUsingStack<Double> stack = new QueueUsingStack(20);
        stack.offer(1.0);
        stack.offer(2.0);
        stack.offer(3.0);
        stack.offer(4.0);
        stack.offer(5.0);
        stack.offer(6.0);
        stack.offer(7.0);
        stack.offer(8.0);
        System.out.println(" size= "+stack.size()+" capacity= "+stack.capacity());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
        stack.print();
        System.out.println(stack.poll());
    }

    QueueUsingStack(int size){
        stack1 = new Stack<>(size);
        stack2 = new Stack<>(size);
    }

    public void offer(T val){
        stack2.reset();
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(val);
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
    }

    public T poll(){
        return stack1.pop();
    }

    public int size(){
        return stack1.size();
    }

    public int capacity(){
        return stack1.capacity();
    }
    public void print(){
        stack1.print();
    }
}
