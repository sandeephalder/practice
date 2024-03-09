package StackQueues;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Queue<T> {
    T[] array;
    int START=0,END=0,size=0;

    public static void main(String[] args) {
       Queue<Double> queue =  new Queue<>(2);
       
        queue.offer(1.0);
        queue.offer(2.0);
        queue.offer(3.0);
        queue.offer(4.0);
        queue.offer(5.0);
        queue.offer(6.0);
        queue.offer(7.0);
        queue.offer(8.0);
        System.out.println(" size= "+queue.size()+" capacity= "+queue.capacity());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.poll());
        queue.offer(1.0);
        queue.print();
        queue.offer(2.0);
        queue.print();
        queue.offer(3.0);
        queue.print();
        queue.offer(4.0);
        queue.print();
        queue.offer(5.0);
        queue.print();
        queue.offer(6.0);
        queue.print();
        queue.offer(7.0);
        queue.print();
        queue.offer(8.0);
        queue.print();
          
    }

   
    Queue(int size){
        this.size=size;
        array = (T[])new Object[size];
        START=END=0;
    }

    public void reset(){
        array = (T[])new Object[size];
        START=END=0;
    }

    public int size(){
        return this.END-this.START;
    }

    public void print(){
        System.out.println();
        System.out.println(Arrays.stream(this.array).collect(Collectors.toList()));
    }

    public int capacity(){
        return this.size;
    }

    public void offer(T val){
       if(END>=size-1) resize(size*2);
       this.array[++END]=val;

    }

    public T peek(){
        return this.array[END];
    }

    public T poll() {
       if(START>=END){
          START=END=0;
          return null;
       }
       if(END<this.size/2 && this.size/2>=2) resize(size/2);
       T val = this.array[++START];
       this.array[START]=null;
       return val;
    }

    private void resize(int newSize){
       T[] newarray=  Arrays.copyOf(this.array, newSize);
       this.size=newSize;
       this.array = newarray;
    }

    public boolean isEmpty(){
        return size()==0;
    }
}
