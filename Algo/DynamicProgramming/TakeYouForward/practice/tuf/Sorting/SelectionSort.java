package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {
    int[] arr ={4,2,0,1,23,45234,-12,23343};
    public static void main(String[] args) {
        new SelectionSort();
    }

    SelectionSort(){
        sort(arr);
        print(arr);
    }

     public void sort(int[] arr){
        int N= arr.length;
        for(int i=0;i<N;i++){
            int mini=i;
            for(int j=i;j<N;j++){
                if(arr[j]<arr[mini]) mini=j;
            }
            swap(arr,i,mini);
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
