package tuf.Sorting;

import java.util.Arrays;

public class IndexSort {
    char[] arr ={'a','c','K','v','i','o','A','y','h','c','s','B'};
    int SIZE= 256;

    public static void main(String[] args) {
        new IndexSort();
    }

    IndexSort(){
        sort(arr);
        printChar(arr);
    }

    public void sort(char[] arr){
        int[] holder = new int[SIZE+1];
        char[] temp = new char[arr.length];
        Arrays.fill(holder,0);
        for(int i=0;i<arr.length;i++) holder[arr[i]+1]++;
        for(int i=0;i<SIZE;i++) holder[i+1] +=holder[i]; 
        for(int i=0;i<arr.length;i++) temp[holder[arr[i]]++] = arr[i];
        for(int i=0;i<arr.length;i++) arr[i] =temp[i];
    }

     public void printInt(int[] arr){
        System.out.println();
        for(int i:arr) System.out.print(" ==> "+i);
        System.out.println();
    }

     public void printChar(char[] arr){
        System.out.println();
        for(char c:arr) System.out.print(" ==> "+c);
        System.out.println();
    }
}
