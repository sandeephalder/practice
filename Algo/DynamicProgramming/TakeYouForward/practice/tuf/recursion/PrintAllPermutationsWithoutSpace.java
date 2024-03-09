package tuf.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PrintAllPermutationsWithoutSpace {
    PrintAllPermutationsWithoutSpace(){
        int[] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        printAllPermutationsWithoutSpace(arr,0,result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new PrintAllPermutationsWithoutSpace();
    }

    private void printAllPermutationsWithoutSpace(int[] arr ,int n,List<List<Integer>> result){
        int N = arr.length-1;
        if(n>N){
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            result.add(list);
            return;
        }
        
        for(int i=n;i<=N;i++){
            
                swap(arr,n,i);
                printAllPermutationsWithoutSpace(arr, n+1,  result);
                swap(arr,i,n);
        }
    }

    private void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest]=temp;
    }
}
