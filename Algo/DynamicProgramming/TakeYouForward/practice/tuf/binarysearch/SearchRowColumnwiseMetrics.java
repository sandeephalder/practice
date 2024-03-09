package binarysearch;

public class SearchRowColumnwiseMetrics {
    int[][] matrix = 
    {
        {1,4,7,11,15},
        {2,5,8,12,19},
        {3,6,9,16,22},
        {10,13,14,17,24},
        {18,21,23,26,30}
    };
    int target=22;
    public static void main(String[] args) {
        new SearchRowColumnwiseMetrics();
    }
    SearchRowColumnwiseMetrics(){
        System.out.println(searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int y=searchInFirstRow(matrix, 0, target);
        int lo =0,hi = y;
        while(lo<=hi){
            int val  = searchInFirstColumn(matrix, hi--, target);
            if(val!=-1) return true;
        }
        return false;
    }

    public int searchInFirstRow(int[][] arr,int row,int target){
        int lo=0,hi = arr[0].length-1,mid=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(arr[row][mid]<target) lo = mid+1;
            else if(arr[row][mid]>target) hi = mid-1;
            else return mid;
        }
        return hi;
    }

    public int searchInFirstColumn(int[][] arr,int column,int target){
        int lo=0,hi = arr.length-1,mid=0;
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(arr[mid][column]<target) lo = mid+1;
            else if(arr[mid][column]>target) hi = mid-1;
            else return mid;
        }
        return -1;
    }
}
