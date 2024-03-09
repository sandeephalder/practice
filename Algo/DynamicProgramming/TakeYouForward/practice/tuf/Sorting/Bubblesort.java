package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubblesort {

    int[] arr ={4,2,0,1,23,45234,-12,23343};

    public static void main(String[] args) {
        new Bubblesort();
    }


    Bubblesort(){
        sort(arr);
        print(arr);
    }

    public void sort(int[] arr){
        int N= arr.length;
        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                if(arr[j-1]>arr[j]) swap(arr,j-1,j);
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
