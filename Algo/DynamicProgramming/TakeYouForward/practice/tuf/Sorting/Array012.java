package Sorting;

import java.util.*;

public class Array012 {
    int[] arr ={1,2,0,1,0,2,0,1,2,0,1,2,0,1,2,0,1};
    public static void main(String[] args) {
        new Array012();
    }

    Array012(){
        sort(arr);
    }

    public void sort(int[] arr){
        print(arr);
        int zero =0,one=0,N=arr.length,two=N-1;
        while(two>one){
            if(arr[one]==1) one++;
            else if(arr[one]==0) {
                exch(arr,zero++,one++);
            }
            else if(arr[one]==2) {
                while(arr[two]==2) --two;
                exch(arr,one,two);
            }
          
        }
        print(arr);
    }

    private void exch(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }

    public void print(int[] arr)
    {
        System.out.println(" Display Array:");
        Arrays.stream(arr).forEach(i-> System.out.print(" ==> "+i));
    }
}
