public class BottomUpMergeSort {
    int[] arr ={3,54,-243,12791,7,203587,0,-23456,-89,76};
    public static void main(String[] args) {
        new BottomUpMergeSort();
    }
    BottomUpMergeSort(){
        int N=arr.length;
        int[] aux = new int[N];
        sort(arr, aux);
        print(arr);
    }

    private void print(int[] ar){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }

    private void sort(int[] arr,int[] aux){
       int N= arr.length;
       for(int i=1;i<N;i *=2){
            for(int j=0;j<N-i;j+=(i+i)){
            int lo =j,hi = Math.min(lo+i+i-1,N-1),mid = lo + i -1;
        
                merge(arr,aux,lo,mid,hi);
        }
          
       }
    }

    private void merge(int[] arr,int[] aux,int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++) aux[i]=arr[i];

        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++){
           if(i>mid) arr[k] = aux[j++];
           else if(j>hi) arr[k] = aux[i++];
           else if(aux[i] > aux[j]) arr[k] = aux[i++];
           else arr[k] = aux[j++];
        }
   }
}
