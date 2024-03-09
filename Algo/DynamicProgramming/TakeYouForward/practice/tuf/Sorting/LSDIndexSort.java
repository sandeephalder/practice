package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LSDIndexSort {

    String[] arr = {"aghsj","knhv","dfg","kjk","werewr","wertwe","jyty","dfgdfg","fghytu","bvcbcv","rdfcx","sedfc","iulih","xcvzfvr","werfr","sacdvgf","csdefs","dfgdsg","cadsfce"};
    int MAX=256,maxlen=10;

    public static void main(String[] args) {
        new LSDIndexSort();
    }

    LSDIndexSort(){
        sort(arr);
        print(arr);
    }

    private void sort(String[] arr){
           int N= arr.length-1;
           String[] temp = new String[N+1];
           for(int a=maxlen;a>=0;a--){
             int[] count = new int[MAX+1];

             for(int i=0;i<=N;i++) count[charAt(arr, i, a)+1]++; 

             for(int i=0;i<MAX;i++) count[i+1] += count[i];

              for(int i=0;i<=N;i++) temp[count[charAt(arr, i, a)]++]=arr[i];

              for(int i=0;i<=N;i++) arr[i]=temp[i];
           }
    }

     private void print(String[] arr){
        System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
    }

    private char charAt(String[] arr,int index,int at){
            if(index<0 || at <0 ||index>=arr.length || at>=arr[index].length()) return 0;
            return arr[index].charAt(at);
    }
}
