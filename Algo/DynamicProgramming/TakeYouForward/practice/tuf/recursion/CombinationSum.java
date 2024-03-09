package tuf.recursion;
import java.util.ArrayList;
import java.util.List;


public class CombinationSum {
    CombinationSum(){
        int target =7;
        int[] arr = {0,3,4,7}; 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        printCombitionationSum(arr, 0, array, result,target);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new CombinationSum();
    }
    private void printCombitionationSum(int[] arr,int n,List<Integer> array ,List<List<Integer>> result,int target){
        int sum = array.stream().mapToInt(i->i).sum();
      
        if(sum==target) {
            result.add(array);
            return;
        }
        
        if(n>arr.length-1){
            return;
        }
       
        
        array.add(arr[n]);
        printCombitionationSum(arr, n+1, new ArrayList<>(array), result,target);
        
        array.remove(array.size()-1);
       
        printCombitionationSum(arr, n+1, new ArrayList<>(array), result,target);
    }

}
