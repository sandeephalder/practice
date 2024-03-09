package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
     int[] arr ={-9874,-2,0,1,23,45234,-12,923343,-98,876};

    public static void main(String[] args) {
        new MergeSort();
    }

     MergeSort(){
        int[] temp = new int[arr.length];
        //sort(arr,0,arr.length-1,temp);
        iterativeSort(arr,temp);
        print(arr);
    }

     public void iterativeSort(int[] arr,int[] temp)
     {
        int N = arr.length;
        for(int count=1;count<N;count*=2){
            System.out.println();
            for(int lo=0;lo<N;lo+=count*2)
            {
              
                System.out.print(" Min="+lo+" Mid="+(lo+count-1)+" Max="+Math.min(lo+2*count-1,N-1) +" ");
                merge(arr, lo, lo+count-1, Math.min(lo+2*count-1,N-1), temp);
                print(arr);
            }
            System.out.println();
        }
       
     }

     public void sort(int[] arr,int lo,int hi,int[] temp){
        if(lo>=hi) return;
        int mid= (lo+hi)/2;
        
        sort(arr,lo,mid,temp);
        sort(arr, mid+1, hi,temp);
        merge(arr, lo, mid,hi, temp);

    }

    public void merge(int[] arr,int lo,int mid,int hi,int[] temp){
        for(int i=lo;i<=hi;i++) temp[i]=arr[i];

        int l= lo,k=mid+1;

        for(int i=lo;i<=hi;i++){
            if(l>mid) arr[i]=temp[k++];
            else if(k>hi) arr[i]=temp[l++];
            else if(temp[l] < temp[k]) arr[i] = temp[l++];
            else arr[i] = temp[k++];
        }
    }

    public void print(int[] arr){
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
