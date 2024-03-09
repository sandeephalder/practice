package recursion2;

import java.util.*;
import java.util.stream.Collectors;

public class FindSubsetWithSum {
    int[] arr = {1,2,3,1,1,1};
    int sum = 8;
    public static void main(String[] args) {
        new FindSubsetWithSum();
    }

    FindSubsetWithSum(){
        Set<List<Integer>> result = new HashSet<>();
        findAllSubarraysSum(arr, arr.length-1, new ArrayList<>(), result);
        System.out.println(result);

        System.out.println(findFirstSubarraysSum(arr, arr.length-1, new ArrayList<>()));
    }

    private void findAllSubarrays(int[] arr,int i,List<Integer> level,Set<List<Integer>> result){
        int N= arr.length-1;
        if(i<0){
            result.add(new ArrayList<>(level));
            return;
        }
        result.add(new ArrayList<>(level));
        level.add(arr[N-i]);
        findAllSubarrays(arr, i-1, level, result);
        findAllSubarrays(arr, i-1, new ArrayList<>(), result);
    }

     private void findAllSubarraysSum(int[] arr,int i,List<Integer> level,Set<List<Integer>> result){
        int N= arr.length-1;
           if(level.stream().collect(Collectors.reducing(0,(a,b)->(a+b)))==sum) result.add(new ArrayList<>(level));
        if(i<0){
            return;
        }
     
        
        level.add(arr[N-i]);
        findAllSubarraysSum(arr, i-1, level, result);
        findAllSubarraysSum(arr, i-1, new ArrayList<>(), result);
    }

     private boolean findFirstSubarraysSum(int[] arr,int i,List<Integer> level){
        int N= arr.length-1;
        if(i<0){
            if(level.stream().collect(Collectors.reducing(0,(a,b)->(a+b)))==sum){
                return true;
            }
            return false;
        }
        if(level.stream().collect(Collectors.reducing(0,(a,b)->(a+b)))==sum)
        return true;
        level.add(arr[N-i]);
        boolean l= findFirstSubarraysSum(arr, i-1, level);
        boolean r = findFirstSubarraysSum(arr, i-1, new ArrayList<>());

        return l || r;
    }
}
