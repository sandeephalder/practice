package recursion2;

import java.util.*;

public class SubsetSum {
    int[] arr = {3,1,2};
    public static void main(String[] args) {
        new SubsetSum();
    }

    SubsetSum(){
        //Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        getAllSum(arr, 0, 0, result);
        System.out.println(result);
    }

    private void getAllSum(int[] arr,int index,int sum,List<Integer> result){
        if(index>=arr.length){
            result.add(sum);
            return ;
        }

        getAllSum(arr, index+1, sum+arr[index], result);
        getAllSum(arr, index+1, sum, result);
    }
}
