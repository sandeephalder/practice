package binarysearch;

public class FindMinInRotatedArray {
    
int[] nums = {3,4,1,2};

public static void main(String[] args) {
    new FindMinInRotatedArray();
}

FindMinInRotatedArray(){
    System.out.println(" Find Min: "+findMin(nums));
}


public int findMin(int[] arr) {
    int lo =0,N=nums.length,hi=N-1,mid=0,min=Integer.MAX_VALUE;
    while(lo<=hi){
        mid = (lo+hi)/2;
        if(arr[lo]<=arr[hi]) {
            min=  Math.min(arr[lo], min);
            break;
        }

        if(arr[lo]<=arr[mid]){
            min = Math.min(arr[lo], min);
            lo = mid+1;
        }
        else{
            min = Math.min(arr[mid], min);
            hi = mid-1;
        } 
    }
    return min;
}

}
