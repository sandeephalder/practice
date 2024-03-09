package StackQueues;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stack<T> {
    T[] array;
    int TOP=0,size=0;

    public static void main(String[] args) {
       Stack<Double> stack =  new Stack<>(2);
       try{
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
       }
       catch(Exception e){
         e.printStackTrace();
       }
      
    }

   

    Stack(int size){
        this.size=size;
        array = (T[])new Object[size];
    }

    public int size(){
        return this.TOP;
    }

    public void print(){
        System.out.println();
        System.out.println(Arrays.stream(this.array).collect(Collectors.toList()));
    }

    public int capacity(){
        return this.size;
    }

    public void push(T val){
        if(TOP>=size-1) resize(size*2);
        this.array[++TOP]=val;
    }

    public T pop() {
        if(TOP<1) return null;
        T val = this.array[TOP];
        this.array[TOP--]=null;
        if(TOP<size/2 && size/2>=2) resize(size/2);
        return val;
    }

    private void resize(int newSize){
       T[] newarray=  Arrays.copyOf(this.array, newSize);
       this.size=newSize;
       this.array = newarray;
    }
    public void reset(){
        array = (T[])new Object[size];
        TOP=0;
    }

    public boolean isEmpty(){
        return size()==0;
    }
}
