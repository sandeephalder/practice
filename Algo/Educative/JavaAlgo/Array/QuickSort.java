public class QuickSort {
    int[] arr ={3,54,-243,12791,7,203587,0,-23456,-89,76};
    public static void main(String[] args) {
        new QuickSort();
    }
    QuickSort(){
        int N=arr.length;
       
        sort(arr,0,N-1);
        print(arr);
    }

    private void print(int[] ar){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }

    private void sort(int[] arr,int lo,int hi){
       int N= arr.length;
       if(lo>=hi) return;
       int j= partition(arr, lo, hi);
       System.out.println(" Lo="+lo+" Partition"+j+" hi="+hi);
       sort(arr,lo,j-1);
       sort(arr, j+1, hi);
    }

    private int partition(int[] arr,int lo,int hi){
        int l = lo,r = hi+1, partition=arr[lo]; 
        while(true){
            while(arr[++l] < partition) if(l >= hi) break;
            while(arr[--r] > partition) if(r<=0) break;
            if(r <=l) break;
            exch(arr,l,r);

        }
        exch(arr,lo,r);
        return r;
   }
   
	private void exch(int[] arr,int start,int end){
        //System.out.println(start+" ==> "+end);
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}
}
