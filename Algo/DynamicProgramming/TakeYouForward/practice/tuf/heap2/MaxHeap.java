package heap2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(20);
        heap.offer(1);
        heap.offer(2);
        heap.offer(3);
        heap.offer(4);
        heap.offer(5);
        heap.print();
        System.out.println(heap.peek());
        System.out.println(heap.getMax());
        heap.print();
        System.out.println(heap.getMax());
        heap.print();
        System.out.println(heap.getMax());
        heap.print();
        System.out.println(heap.getMax());
        heap.print();
        System.out.println(heap.getMax());
        heap.print();
        System.out.println(heap.getMax());
        heap.print();
    }

    int[] array;
    int size=0,TOP=0;

    public int size(){
        return TOP;
    }
    
    
    MaxHeap(int size){
        array = new int[size];
        this.size=size;
    }

    public void offer(int val){
        if(TOP>=size) return;
        array[++TOP]=val;
        swim(TOP);
    }

    public int peek(){
        return array[1];
    }

    public int getMax(){
        if(TOP<1) return -1;
        int res = array[1];
        exch(1, TOP--);
        array[TOP+1]=0;
        sink(1);
        return res;
    }

    private void sink(int index){
        int k =index;
        while(k*2<=TOP){
            int n= 2*k;
            if(n<TOP && array[n]<array[n+1]) n++;
            if(n>=TOP || array[k]>array[n]) break;
            exch(k, n);
            k=n;
        }
    }

    private void swim(int index){
        int k= index;
        while(k>1 && array[k]>array[k/2]){
            exch(k/2, k);
            k /=2;
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
