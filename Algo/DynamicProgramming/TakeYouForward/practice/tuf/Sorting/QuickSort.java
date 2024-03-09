package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
     int[] arr ={4,2,0,1,23,-45234,-12,23343};
     int[] arr1 ={0,0,1,0,2,3,2,3,1,0,5,1,2,3,0,1,2,3,2,1,3,0,2,1,3,2,1,};

    public static void main(String[] args) {
        new QuickSort();
    }

     QuickSort(){
        sort(arr,0,arr.length-1);
        threeWaySort(arr1,0,arr1.length-1);
        print(arr1);
    }


    public void threeWaySort(int[] arr,int lo,int hi){
        int part=arr[lo],l=lo,r=hi,i=lo;
        if(lo>=hi) return;
        while(i<=r){
            if(arr[i]<part) swap(arr, i++, l++);
            else if(arr[i]>part) swap(arr, i, r--);
            else i++;
        }
        threeWaySort(arr, lo, l-1);
        threeWaySort(arr, r+1, hi);
     }


     public void sort(int[] arr,int lo,int hi){
        if(lo>=hi) return;

        int part = partition(arr, lo, hi);

        sort(arr, lo, part-1);
        sort(arr, part+1, hi);
     }

    public int partition(int[] arr,int lo,int hi){
        int start=lo,end=hi,part=arr[start];
        while(end>=start){
            while(start<=hi && arr[start]<=part) start++;
            while(end>=0 && arr[end]>part) end--;
            if(start>end) break;
            swap(arr,start,end);
        }
        
        swap(arr, lo, end);

        return end;
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
