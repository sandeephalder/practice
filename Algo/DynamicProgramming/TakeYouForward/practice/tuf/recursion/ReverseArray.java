package tuf.recursion;

import java.util.Arrays;

public class ReverseArray {
    ReverseArray(){
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,2,3,4,5,6};
        System.out.println("Reverse array approach 1");
        reverse2Pointer(arr1, 0, arr1.length-1);
        printArray(arr1);
        System.out.println("\nReverse array approach 2");
        reverse1Pointer(arr2, 0);
        printArray(arr2);
    }

    public static void main(String[] args) {
        new ReverseArray();
    }

    private void reverse2Pointer(int[] arr,int i,int j){
        if(i>=j) return;
        swap(arr, i, j);
        reverse2Pointer(arr, i+1, j-1);
    }

    private void reverse1Pointer(int[] arr,int i){
        int j =  arr.length-1 -i;
        if(i>=j) return;
        swap(arr, i,j);
        reverse1Pointer(arr, i+1);
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void printArray(int[] arr){
        System.out.println("Print Array");
        Arrays.stream(arr).forEach(i-> System.out.print(" ==> "+i));
    }
}
