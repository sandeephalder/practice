package tuf.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MSTIndexSort {

    String[] arr = {"aghsj","knhv","dfg","kjk","werewr","wertwe","jyty","dfgdfg","fghytu","bvcbcv","rdfcx","sedfc","iulih","xcvzfvr","werfr","sacdvgf","csdefs","dfgdsg","cadsfce"};
    int MAX=256,maxlen=10;

    public static void main(String[] args) {
        new MSTIndexSort();
    }

    MSTIndexSort(){
        int N= arr.length;
        String[] aux = new String[N];
        sort(arr,aux,0,N-1,0);
        print(arr);
    }

    private void sort(String[] arr,String[] aux,int lo,int hi,int d){
        if(lo>=hi) return; 
        int N= arr.length-1;
        int[] count = new int[MAX+2];

        for(int i=lo;i<=hi;i++) count[charAt(arr, i, d)+2]++;
        for(int i=0;i<MAX+1;i++) count[i+1] += count[i];
        for(int i=lo;i<=hi;i++) aux[count[charAt(arr, i, d)+1]++]=arr[i-lo];
        for(int i=lo;i<=hi;i++) arr[i]=aux[i];

        for(int i=0;i<MAX;i++) sort(arr, aux, lo+count[i], lo+count[i+1]-1, d+1);

 }

    private void print(String[] arr){
        System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
    }

    private char charAt(String[] arr,int index,int at){
            if(index<0 || at <0 ||index>=arr.length || at>=arr[index].length()) return 0;
            return arr[index].charAt(at);
    }
}
