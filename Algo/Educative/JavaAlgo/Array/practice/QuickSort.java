package practice;

public class QuickSort {
    public static void main(String[] args) {
        new QuickSort();
    }

    QuickSort(){
        int arr[] = {1, 2, 4, -5, -10, 6, 3}; 
        int N= arr.length;
        print(arr);
        sort(arr,0,N-1);
        print(arr);
    }

    private void print(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }
    private void sort(int[] arr,int lo,int hi){
      if(lo>=hi) return;

      int j= partition(arr, lo, hi);

      sort(arr, lo, j-1);
      sort(arr,j+1, hi);
    }

    private int partition(int[] arr,int lo,int hi){
      int i=lo,j=hi+1,partition=arr[lo];
        while(true){
            while(arr[++i]<partition) if(i >= hi) break;
            while(arr[--j]>partition) if(j <= lo) break;
            
            if(i>=j) break;
            exch(arr,i,j);
        }
        exch(arr,lo,j);
      return j;
    }

    private void exch(int[] arr,int start,int end){
        //System.out.println(start+" ==> "+end);
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}
}
