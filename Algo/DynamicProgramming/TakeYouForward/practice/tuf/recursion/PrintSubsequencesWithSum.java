package tuf.recursion;
import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithSum {
    PrintSubsequencesWithSum(){
        int[] arr = {3,1,2}; 
        List<Integer> result = new ArrayList<>();
        printSubsequencesWithSum(arr, 0, 0, result);
        System.out.println(result);
    }
    public static void main(String[] args) {
        new PrintSubsequencesWithSum();
    }

    private void printSubsequencesWithSum(int[] arr,int n,int sum,List<Integer> result){
        if(n>arr.length-1){
            result.add(sum);
            return;
        }
        sum += arr[n];
        printSubsequencesWithSum(arr, n+1, sum, result);
        sum -= arr[n];
        printSubsequencesWithSum(arr, n+1, sum, result);
    }
}
