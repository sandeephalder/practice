package recursion2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    int[] arr = {1,2,3,4,5,6,7,8,9};
    int T=13,size=3;
    public static void main(String[] args) {
        new CombinationSum3();
    }

    CombinationSum3(){
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(arr, 0, 0,new ArrayList<>(), result);
        System.out.println(result);
    }

    public void combinationSum3(int[] arr, int index,int sum,List<Integer> level,List<List<Integer>> result) {
        
        if(sum==T && level.size()==size){
            result.add(new ArrayList<>(level));
            return;
        }
        
        if(level.size()>size || sum >T || index >=arr.length){
            return;
        }
        //System.out.println(index);
            level.add(arr[index]);
            combinationSum3(arr, index+1, sum+arr[index], level, result);
            level.remove(level.size()-1);
            combinationSum3(arr, index+1, sum, level, result);
       
    }
}
