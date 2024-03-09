package practice;

public class MergeSort {
    public static void main(String[] args) {
        new MergeSort();
    }

    MergeSort(){
        int arr[] = {1, 2, 4, -5, -10, 6, 3}; 
        int N= arr.length;
        int[] aux = new int[N];
        print(arr);
        sort(arr,aux,0,N-1);
        print(arr);
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }
    private void sort(int[] arr,int[] aux,int lo,int hi){
      if(lo>=hi) return;

      int mid = lo + (hi-lo)/2;

      sort(arr,aux,lo,mid);
      sort(arr,aux,mid+1,hi);
      merge(arr,aux,lo,mid,hi);
    }

    private void merge(int[] arr,int[] aux,int lo,int mid,int hi){
      for(int i=lo;i<=hi;i++) aux[i] = arr[i];

      int i=lo,j=mid+1;
      for(int k=lo;k<=hi;k++){
          if(i>mid) arr[k] = aux[j++];
          else if(j>hi) arr[k] = aux[i++];
          else if(aux[i]>aux[j]) arr[k] = aux[i++];
          else arr[k] = aux[j++];
      } 
    } 
}
