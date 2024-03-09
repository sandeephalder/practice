package binarysearch;

public class FindFastAndLastOccurance {
    int[] arr = {8,10};
    int target =7;
    public static void main(String[] args) {
        new FindFastAndLastOccurance();
    }

    FindFastAndLastOccurance(){
        int[] res = searchRange(arr, target);
        System.out.println(" lo = "+res[0]+" hi = "+res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length==0) return result;
        int lowerBound = lowerBound(nums, target);
        int upperBound = upperBound(nums, target);
        System.out.println(" lowerBound 1= "+lowerBound);
        System.out.println(" upperBound 1= "+upperBound);
        lowerBound = nums[lowerBound] != target?-1:lowerBound;
        upperBound = nums[upperBound] != target?-1:upperBound;
        System.out.println(" lowerBound 2= "+lowerBound);
        System.out.println(" upperBound 2= "+upperBound);
        return result;
    }

    private int lowerBound(int[] nums, int target){
        int N=nums.length,pos=N-1,lo=0,hi=N-1,mid=0;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(target<=arr[mid]){
                hi = mid-1;
                pos= mid;
            }
            else{
                lo = mid+1;
            }
        }
        return pos;
    }

    private int upperBound(int[] nums, int target){
        int N=nums.length,pos=N-1,lo=0,hi=N-1,mid=0;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(target>=arr[mid]){
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
