package practice.practice2;

public class NumberSort {
    public static void main(String[] args) {
        new NumberSort();
    }

    NumberSort(){
        int[] arr = {23,2,43,567,12,78,23,45,90};
        int[] arr1 ={1,3,2,4,5,6,2,1,8,7,5,6,7,8};
        //bubbleSort(arr);,,,
        //selectionSort(arr);
        //insertionSort(arr);
        //mergeSort(arr);
        //quickSort(arr);
        indexSort(arr1);
        print(arr1);
    }

    private void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++)
            if(arr[j]>arr[j+1]) exch(arr,j,j+1);
        }
    }

    private void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++)
            if(arr[minIndex]>arr[j]) 
            minIndex=j;
            exch(arr,i,minIndex);
        }
    }

    private void insertionSort(int[] arr){
        for(int i=0;i<arr.length;i++){    
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]) exch(arr,j,j-1);
            }
            
        }
    }

    private void mergeSort(int[] arr){
        int aux[] = new int[arr.length];
        msort(arr,aux, 0, arr.length-1);
    }
    private void msort(int[] arr,int[] aux,int lo,int hi){
        if(lo>=hi)
        return;

        int mid = lo + (hi-lo)/2;

        msort(arr,aux, lo, mid);
        msort(arr,aux, mid+1, hi);
        merge(arr,aux, lo, mid, hi);
    }

    private void merge(int[] arr,int[] aux,int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++)
        aux[i]=arr[i];

        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++)
        {
            if(i>mid) arr[k]= aux[j++];
            else if(j>hi) arr[k] = aux[i++];
            else if(aux[i]>aux[j]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }

    }

    private void quickSort(int[] arr){
       
        qsort(arr, 0, arr.length-1);
    }

    private void indexSort(int[] arr){
        int N=arr.length,K=10;
       int[] aux = new int[K];
        int temp[] = new int[N];
        for(int i=0;i<N;i++)
            aux[arr[i]+1]++;
        for(int j=1;j<K;j++)
         aux[j] = aux[j]+aux[j-1];
        for(int i=0;i<N;i++)
          temp[aux[arr[i]]++]= arr[i];
        for(int i=0;i<N;i++)
          arr[i]=temp[i];
        print(temp);
    }

   

private void qsort(int[] arr,int lo,int hi){
        if(lo>=hi)
        return;

        int partition = partition(arr, lo, hi);

        qsort(arr, lo, partition-1);
        qsort(arr, partition+1, hi);    
        
    }

    private int partition(int[] arr,int lo,int hi){
        int i=lo,j=hi+1,part= arr[lo];
        while(true){
            while(i<hi && arr[++i] < part);
            while(j>lo && arr[--j] > part);
            
            if(i>=j) break;
            exch(arr,i,j);
        }
        exch(arr,lo,j);
        return j;
    }
    private void exch(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

    private void print(int arr[]){
        System.out.println("Array ==>");
        for(int i=0;i<arr.length;i++){
            System.out.print(" ==> "+arr[i]);
        }
     }
}
