package Arrays;

public class CountInversions {
    static int arr[] = {5, 3, 2, 1, 4};
    public static void main(String[] args) {
        
        System.out.println(numberOfInversions(arr, arr.length));
        print(arr);
    }
    //1 3 5 || 2 3 4 
    public static int numberOfInversions(int []arr, int n) {
        return sort(arr, 0, arr.length-1);
    }

    public static int sort(int []arr,int lo,int hi){
        if(lo>=hi) return 0;
        int mid = (lo+hi)/2;

        int l = sort(arr, lo, mid);
        int r =sort(arr, mid+1, hi);
         
        int c= merge(arr, lo, mid, hi);
    
        return l+r+c;
    }

   

    public static int merge(int []arr,int lo,int mid,int hi){
        int[] temp = new int[arr.length];
        for(int i=lo;i<=hi;i++) temp[i]=arr[i];

        int j=lo,k=mid+1,count=0;;

        for(int i=lo;i<=hi;i++){
            if(j>mid) arr[i]=temp[k++];
            else if(k>hi) arr[i]=temp[j++];
            else if(temp[k]>temp[j]) arr[i]=temp[j++];
            else {
                arr[i]=temp[k++];
                count += mid-j+1;
            }
        }
         
        return count;
    }

    private static void print(int[] arr){
        System.out.println();
        for(int i:arr){
            System.out.print("["+i+"],");
        }
}
}
