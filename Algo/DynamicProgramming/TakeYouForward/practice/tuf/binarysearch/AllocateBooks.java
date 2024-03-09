package binarysearch;

import java.util.Arrays;

public class AllocateBooks {
    int[] array = {25, 46 ,28 ,49,24};
    int m=4,n=array.length;
    public static void main(String[] args) {
       new AllocateBooks();
    }

    AllocateBooks(){
         System.out.println(findPages(array, n, m));
         //System.out.println(calculateStudents(array, 18));
    }
   

    public int findPages(int[] arr, int n, int m) {
        int lo = Arrays.stream(arr).max().getAsInt(),hi=Arrays.stream(arr).sum(),mid=0;
        while(lo<=hi){
            mid=(lo+hi)/2;
            int result = calculateStudents(arr, mid);
            if(result>m) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }

    private int calculateStudents(int[] arr, int pages){
        int n = arr.length;// size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr[i] <= pages) {
                // add pages to current student
                pagesStudent += arr[i];
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
}
