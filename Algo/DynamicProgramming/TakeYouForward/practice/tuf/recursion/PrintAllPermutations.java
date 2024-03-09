package tuf.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrintAllPermutations {
    PrintAllPermutations(){
        int[] arr = {1,2,3};
        boolean[] isIncluded = new boolean[arr.length];
        Arrays.fill(isIncluded, false);
        List<List<Integer>> result = new ArrayList<>();
        printAllPermutations(arr,0,isIncluded ,new ArrayList<>(),result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new PrintAllPermutations();
    }

    private void printAllPermutations(int[] arr ,int n,boolean[] isIncluded,List<Integer> array,List<List<Integer>> result){
        int N = arr.length-1;
        if(n>N){
            List<Integer> newArray = new ArrayList<>(array);
            result.add(newArray);
            return;
        }

        for(int i=0;i<=N;i++){
            if(!isIncluded[i]){
                array.add(arr[i]);
                isIncluded[i]=true;
                printAllPermutations(arr, n+1,isIncluded, array, result);
                isIncluded[i]=false;
                array.remove(array.size()-1);
            }
            
        }
    }
}
