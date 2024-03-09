package recursion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumRepetative {


    int[] arr ={10,1,2,7,6,1,5};
    int T =8;

    public static void main(String[] args) {
        new CombinationSumRepetative();
    }

    CombinationSumRepetative(){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        combinationSumList(arr, T,0,new ArrayList<>(), result);
        System.out.println(result);
    }


    private void combinationSumList(int[] arr,int target,int index,List<Integer> level,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(level));
            return;
        }
        
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;

            if(arr[i]>T) break;

            level.add(arr[i]);
            combinationSumList(arr, target-arr[i], i+1, level, result);
            level.remove(level.size()-1);
        }
    }
}
