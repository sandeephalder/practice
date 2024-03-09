package practice.practice2;

import java.util.Arrays;

public class MinHip {
    int N=10,TOP=0;
    int[] arr;
    
    public static void main(String[] args) {
        new MinHip();
    }

    MinHip(){
        arr = new int[N];
        buildHip();
    }
    private void print(int arr[]){
       System.out.println("Array ==>");
       for(int i=0;i<arr.length;i++){
           System.out.print(" ==> "+arr[i]);
       }
    }

    private void buildHip(){
        insert(34);
        insert(78);
        insert(90);
        insert(12);
        insert(9);
        print(arr);
        System.out.println(deleteMin());
        print(arr);
        System.out.println(deleteMin());
        print(arr);
        System.out.println(deleteMin());
        print(arr);
    }

    private void insert(int val){
      arr[++TOP]=val;
      swim(TOP);
    }

    private int deleteMin(){
        int R= arr[TOP--];
        exch(arr,1,TOP+1);
        arr[TOP+1]=-1;
        sink(1);
        return R;
    }

    private void sink(int index){
        int n= index*2;
        while(n<TOP){
            if(arr[n+1]>arr[n]) n++;
            if(n>=TOP && arr[n] > arr[index]) break;
            exch(arr,n,index);
            index=n;
        }
    }

    private void swim(int index){
        while(index/2>1){
            if(index/2 >1 && arr[index]<arr[index/2]) exch(arr,index,index/2);
            index = index/2;
        }
    }

    private void exch(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

}
