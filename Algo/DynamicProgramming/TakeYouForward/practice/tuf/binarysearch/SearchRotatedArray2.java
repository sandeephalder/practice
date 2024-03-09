package binarysearch;

public class SearchRotatedArray2 { 

int[] nums = {2,5,6,0,0,1,2};
int target=3;
public static void main(String[] args) {
    new SearchRotatedArray2();
}

SearchRotatedArray2(){
    System.out.println(" Search: "+search(nums, target));
}

public boolean search(int[] nums, int target) {
    int lo=0,N=nums.length,hi=N-1,mid=0;
    while(lo<=hi){
        mid = (lo+hi)/2;
        if(nums[mid]==target) return true;
        if(nums[lo]==nums[mid]&&nums[mid]==nums[hi]) {
            hi--;
            lo++;
            continue;
        }
        if(nums[lo]<=nums[mid]){
            if(nums[lo]<=target && target<=nums[mid]){
                hi=mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        else{
            if(nums[mid]<=target && target<=nums[hi]){
                lo = mid+1;
                
            }
            else{
                hi=mid-1;
            }
        }
    }
    return false;
}
}
