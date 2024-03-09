package tuf.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctCombinationSum {
    DistinctCombinationSum(){
        int target =3;
        int[] arr = {0,1,0,1,2,1,0,2}; 
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        printDistinctCombitionationSum(arr, 0, array, result,target);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new DistinctCombinationSum();
    }
    private boolean printDistinctCombitionationSum(int[] arr,int n,List<Integer> array ,List<List<Integer>> result,int target){
        
        int N = arr.length-1;
        int last = -1;
        boolean anyMatch=false;

           
        for(int i=n;i<=N;i++){
            int newTarget = target-arr[i];
            if(arr[i]==last) continue;
            anyMatch=true;
            last = arr[i];
            List<Integer>  newList = new ArrayList<>(array);
            newList.add(arr[i]);
            if(newTarget!=0)
                printDistinctCombitionationSum(arr, i+1,newList, result,newTarget);
            else 
                result.add(newList);
        }
        return anyMatch;
       
       
    }
}
