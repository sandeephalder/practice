package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {

    int[] arr ={4,2,0,1,23,45234,-12,23343};

    public static void main(String[] args) {
        new InsertionSort();
    }

     InsertionSort(){
        sort(arr);
        print(arr);
    }

     public void sort(int[] arr){
        int N= arr.length;
        for(int i=0;i<N;i++){
            
            for(int j=i;j>0;j--){
                if(arr[j]>arr[j-1]) swap(arr,j,j-1);
            }
            
        }
    }

    public void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]= arr[dest];
        arr[dest]=temp;

}

    public void print(int[] arr){
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
