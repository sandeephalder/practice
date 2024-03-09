package binarysearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
    int arr[]= {7,2,5,10,8};
    int k=2,n=arr.length;

    public static void main(String[] args) {
        new SplitArrayLargestSum();
    }

    SplitArrayLargestSum(){
        System.out.println("Split Array ==> "+splitArray(arr, k));
    }

    public int splitArray(int[] nums, int k) {
        int lo = Arrays.stream(nums).max().getAsInt(),hi=Arrays.stream(nums).sum(),mid=0;
       
        while(lo<=hi){
            mid = (lo+hi)/2;
            int c = countPartitions(nums, mid);
            if(c>k) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }

    private int countPartitions(int[] nums, int length){
        int partition=1,carry=0;
        for(int i=0;i<n;i++){
            if(nums[i]+carry<=length){
                carry += nums[i];
            }
            else{
                partition++;
                carry = nums[i];
            }
        }
        return partition;
    }

}
