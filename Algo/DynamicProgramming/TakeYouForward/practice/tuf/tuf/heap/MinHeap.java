package tuf.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinHeap {
     int[] arr;
    //int[] input  = {76598,32984,785946,234,6978,321,756984,1928,574365};
    int[] input  = {1,2,3,4,5,6,7,8,9};
    int size=0,TOP=0;

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        for(int i: heap.input) heap.insert(i);
        heap.print();
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        heap.print();
    }

    MinHeap(int size){
        this.size=size;
        arr = new int[size];
        Arrays.fill(arr,0);
    }

    public int deleteMin(){
      if(TOP<1) return -1;
      int val = arr[1];
      arr[1]=arr[TOP--];
      arr[TOP+1]=0;
      sink(arr,1);
      return val;
    }

    public int insert(int val){
    if(TOP>size)
       return -1;
    arr[++TOP] = val;
    swim(arr,TOP);
    return 0;
    }

    private void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

    private void swim(int[] arr,int index){
        while(index>1 && arr[index]<arr[index/2]){
            swap(arr,index,index/2);
            index=index/2;
        }
    }

    private void sink(int[] arr,int index){
       while(2*index<size){
         int k= 2*index;
         if(k<size && arr[k]>arr[k+1]) k++;
         if(k>=size || arr[k]>arr[index]) break;
         swap(arr,k,index);
         index=k;
       }
    }

    private void print(){
        System.out.println();
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println();
    }

}
