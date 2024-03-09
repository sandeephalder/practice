package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsequence {
    public static void main(String[] args) {
        new PrintSubsequence();
    }

    PrintSubsequence(){
        int[] arr = {3,1,2};
        List<int[]> lists = new ArrayList<>();
        int[] buffer = new int[0];
        generateSubsequences(lists,arr,buffer,0);
        for(int[] a:lists) printArray(a);
        


    }

    private void generateSubsequences(List<int[]> lists,int[] arr,int[] buffer,int index){
        if(index >= arr.length) {
            lists.add(buffer);
            return;
        }
        generateSubsequences(lists,arr,buffer,index+1);
        buffer = addToArray(buffer, arr[index]);
        generateSubsequences(lists,arr,buffer,index+1);
        //buffer = removeLastIndexFromArray(buffer);
        //generateSubsequences(lists,arr,buffer,index+1);
    }

    private int[] removeLastIndexFromArray(int[] arr){
        return Arrays.copyOf(arr, arr.length-1);
    }

    private int[] addToArray(int[] arr,int element){
        int[] newArray = new int[arr.length+1];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
         newArray[newArray.length-1]=element;
         return newArray;
    }

    private void printArray(int arr[]){
        System.out.println();
        for(int i: arr)
            System.out.print("==>"+i);
        System.out.println();
    }
}
