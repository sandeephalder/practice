public class Partition {
    public static void main(String[] args) {
        new Partition();
    }

    Partition(){
        int[] arr = {9,2,3,6};
        int lo=0;
        for(int i: arr) System.out.print(" ==> "+i);
       
        while(lo<arr.length-1) 
        lo = partition(arr, lo+1);
        System.out.println("Lo "+lo);
        for(int i: arr) System.out.print(" ==> "+i);
        //System.out.println(partition(arr));
    }

    private int partition(int arr[],int lo){
        int hi=arr.length-1,partition=arr[lo];
        while(lo<=hi){
            while(lo <arr.length && arr[lo] < partition) lo++;
            while(hi >=0 && arr[hi] > partition) hi--;
            if(lo>=hi) break;
            exch(arr,hi,lo);
            
        }
        //exch(arr,0,lo);
        return lo;
    }

    private static int[] exch(int[] arr,int start,int end){
        System.out.println(start+" ==> "+end);
		int temp =arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		return arr;
	}
}
