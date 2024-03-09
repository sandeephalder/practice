package recursion2;

import java.util.*;

class CombinationSum{

    int[] arr ={2,3,6,7};
    int T =9;
    public static void main(String[] args) {
        new CombinationSum();
    }

    CombinationSum(){
        List<List<Integer>> result = new ArrayList<>();
        combinationSumList(arr, 0,0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private void combinationSumList(int[] arr,int target,int index,List<Integer> level,List<List<Integer>> result){
        if(target==T){
            result.add(new ArrayList<>(level));
            return;
        }
        if(index>=arr.length){
            return;
        }
        
        level.add(arr[index]);
        combinationSumList(arr, target+arr[index], index+1, level, result);
        level.remove(level.size()-1);
        combinationSumList(arr, target, index+1, level, result);
    }
}