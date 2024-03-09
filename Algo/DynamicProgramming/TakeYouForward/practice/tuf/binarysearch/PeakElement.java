package binarysearch;

public class PeakElement {
    int[] nums ={1,2,1,3,5,6,4};
    public static void main(String[] args) {
        new PeakElement();
    }

    PeakElement(){
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int lo=1,N=nums.length-1,hi=N-1,mid=0;
        if(N==0) return nums[N];
        if(nums[0]>nums[1]) return 0;
        if(nums[N]>nums[N-1]) return N;
        while(lo<=hi){
            mid = (lo+hi)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            if(nums[mid-1]<nums[mid]) lo = mid+1;
            else hi = mid-1;

        }
        return -1;
    }
}
