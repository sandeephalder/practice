package binarysearch;

public class FindHowManyTimesArrayRoated {
    static int[] arr ={3, 4, 5, 1, 2};
    public static void main(String[] args) {
        System.out.println(findKRotation(arr));
    }

    public static int findKRotation(int []arr){
        int lo=0,N=arr.length,hi=N-1,mid=0,min=Integer.MAX_VALUE,minIndex=0;;
        while(lo<=hi){
            mid = (hi+lo)/2;
            if(arr[lo]<=arr[hi]){
                if(arr[lo]<min){
                    min = arr[lo];
                    minIndex=lo;
                }
            }

            if(arr[lo]<=arr[mid]){
                if(arr[lo]<min){
                    min = arr[lo];
                    minIndex=lo;
                }
                lo = mid+1;
            }
            else{
                if(arr[mid]<min){
                    min = arr[mid];
                    minIndex=mid;
                }
                hi = mid-1;
            }
        }
        return minIndex;
    }
}
