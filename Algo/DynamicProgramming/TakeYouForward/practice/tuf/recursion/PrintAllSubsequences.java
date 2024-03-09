package tuf.recursion;
import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    PrintAllSubsequences(){
        int[] arr = {3,1,2}; 
        List<Integer> array = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        printAllSubsequences(arr, 0, array, result);
        System.out.println(result);
    }
    public static void main(String[] args) {
        new PrintAllSubsequences();
    }

    private void printAllSubsequences(int[] arr,int  n,List<Integer> array,List<List<Integer>> result){
        if(n>arr.length-1) {
            result.add(array);
            return;
        }
        array.add(arr[n]);
        printAllSubsequences(arr, n+1, new ArrayList<>(array), result);
        array.remove(array.size()-1);
        printAllSubsequences(arr, n+1, new ArrayList<>(array), result);
    }
}
