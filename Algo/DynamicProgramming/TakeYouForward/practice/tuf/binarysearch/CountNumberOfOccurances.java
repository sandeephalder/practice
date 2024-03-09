package binarysearch;

public class CountNumberOfOccurances {
    static int[] arr = {8,8,8,10};
    static int target =8;

    public static void main(String[] args) {
        System.out.println(count(arr, arr.length, target));
    }
    public static int count(int arr[], int n, int x) {
        int result=0;
        int res[] = searchRange(arr, x);
        if(res[0]==-1 || res[1]==-1) return result;
        result = res[1]-res[0];
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length==0) return result;
        int lowerBound = lowerBound(nums, target);
        int upperBound = upperBound(nums, target);
     
        lowerBound = nums[lowerBound] != target?-1:lowerBound;
        upperBound = nums[upperBound] != target?-1:upperBound;
        result[0]=lowerBound;
        result[1]=upperBound;
        System.out.println(" lowerBound= "+lowerBound);
        System.out.println(" upperBound= "+upperBound);
        return result;
    }

    private static int lowerBound(int[] nums, int target){
        int N=nums.length,pos=N-1,lo=0,hi=N-1,mid=0;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(target<=nums[mid]){
                hi = mid-1;
                pos= mid;
            }
            else{
                lo = mid+1;
            }
        }
        return pos;
    }

    private static int upperBound(int[] nums, int target){
        int N=nums.length,pos=N-1,lo=0,hi=N-1,mid=0;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(target>=nums[mid]){
                lo = mid+1;
                
                pos= mid;
            }
            else{
                hi = mid-1;
            }
        }
        return pos;
    }
}
