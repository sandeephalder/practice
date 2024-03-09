package recursion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinationsWithRepetatedElements {

    int[] arr = {1,2,2};

    public static void main(String[] args) {
        new UniqueCombinationsWithRepetatedElements();
    }

    UniqueCombinationsWithRepetatedElements(){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        combinationSumList(arr, 0,new ArrayList<>(), result);
        System.out.println(result);
    }

    private void combinationSumList(int[] arr,int index,List<Integer> level,List<List<Integer>> result){
        
            result.add(new ArrayList<>(level));
         
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;

            level.add(arr[i]);
            combinationSumList(arr, i+1, level, result);
            level.remove(level.size()-1);
        }
    }
}
