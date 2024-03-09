package binarysearch;

public class FindKthMissingPositiveNumber {
    int array[] = {2,3,4,7,11};
    int k=5;
    public static void main(String[] args) {
        new FindKthMissingPositiveNumber();
    }

    FindKthMissingPositiveNumber(){
        System.out.println(findKthPositive(array, k));
    }

    public int findKthPositive(int[] arr, int k) {
        int N=arr.length,lo=0,hi=N-1,mid=0,missing=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            missing = arr[mid]-(mid+1);
            if(missing<k) lo = mid+1;
            else hi= mid-1;
        }
        int result= k+hi+1;
        return result;
    }
}
