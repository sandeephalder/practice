package heap2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinHeap {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.offer(5);
        heap.offer(4);
        heap.offer(3);
        heap.offer(2);
        heap.offer(1);
        heap.print();
        System.out.println(heap.peek());
        System.out.println(heap.pop());
        heap.print();
        System.out.println(heap.pop());
        heap.print();
        System.out.println(heap.pop());
        heap.print();
        System.out.println(heap.pop());
        heap.print();
        System.out.println(heap.pop());
        heap.print();
        System.out.println(heap.pop());
        heap.print();
    }

    int[] array;
    int size=0,TOP=0;

    public int size(){
        return TOP;
    }
    
    MinHeap(int size){
        array = new int[size];
        this.size=size;
    }

    public void offer(int val){
        if(TOP>size)
        return ;
        array[++TOP]=val;
        swim(TOP);
    }

    public int peek(){
        return array[1];
    }

    public int pop(){
        if(TOP<1) return -1;
        int res=array[1];
        array[1]=array[TOP--];
        array[TOP+1]=0;
        sink(1);
        return res;
    }

    private void sink(int index){
        int k= index;
        while(2*k<=TOP){
            int n= 2*k;
            if(n< TOP && array[n]>array[n+1]) n++;
            if(n>=TOP || array[n]>array[k]) break;
            exch(k,n);
            k=n;
        }
    }

    private void swim(int index){
        int k=index;
        while(k>1 && array[k]<array[k/2]){
                exch(k/2, k);
                k=k/2; 
        }
    }

    private void exch(int src,int dest){
        int temp=0;
        temp = array[src];
        array[src] = array[dest];
        array[dest] = temp;
    }

      private void print(){
        System.out.println(" ===> ");
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
        System.out.println(" ===> ");
    }
}
