package binarysearch;

public class SingleElementInSortedArray {
    int[] nums = {1,1,3,3,8,9,9};
    public static void main(String[] args) {
        new SingleElementInSortedArray();
    }

    SingleElementInSortedArray(){
        System.out.println(singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int lo=1,N=nums.length,hi=N-2,mid=0;
        if (N== 1)
            return nums[0];
        if (nums[0]!=nums[1]) 
            return nums[0];
        if (nums[N-1]!=nums[N-2])
            return nums[N-1];
        while(lo<=hi){
            mid = (lo+hi)/2;
            //System.out.println(mid);
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            if((mid%2==1&&(nums[mid]==nums[mid-1])) || (mid%2==0&&(nums[mid]==nums[mid+1]))){
              
                lo = mid+1;  
            }
            else{
                hi = mid-1;
            }
        }

        return -1;
    }
}
