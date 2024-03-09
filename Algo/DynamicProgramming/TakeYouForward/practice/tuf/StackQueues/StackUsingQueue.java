package StackQueues;

public class StackUsingQueue<T> {
    Queue<T> queue1 = null,queue2 = null;
    public static void main(String[] args) {
        StackUsingQueue<Double> stack = new StackUsingQueue(20);
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        stack.push(5.0);
        stack.push(6.0);
        stack.push(7.0);
        stack.push(8.0);
        System.out.println(" size= "+stack.size()+" capacity= "+stack.capacity());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.pop());
    }

    StackUsingQueue(int size){
        queue1 = new Queue<>(size);
        queue2 = new Queue<>(size);
    }

    public void push(T val){
        queue2.reset();
        while(!queue1.isEmpty()) if(queue1.peek()!=null) queue2.offer(queue1.poll());
        queue1.offer(val);
        while(!queue2.isEmpty()) if(queue2.peek()!=null) queue1.offer(queue2.poll());
    }

    public T pop(){
        return queue1.poll();
    }

    public int size(){
        return queue1.size();
    }

    public int capacity(){
        return queue1.capacity();
    }
    public void print(){
        queue1.print();
    }
}
