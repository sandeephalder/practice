package binarysearch;

public class SearchInRoatedArray1 {
    int[] arr = {4,5,6,7,0,1,2};
    int target=9;
    public static void main(String[] args) {
        new SearchInRoatedArray1();
    }

    SearchInRoatedArray1(){
        System.out.println(" Search: "+search(arr, target));
    }

    public int search(int[] nums, int target) {
        int lo =0,N=nums.length,hi=N-1,mid=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(nums[mid]==target) return mid;
            if(arr[lo]<=arr[mid]){
                if(arr[lo]<=target && target<=arr[mid]){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }

            }
            else{
                if(arr[mid]<=target && target<=arr[hi]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
