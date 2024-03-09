import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintUniqueCombinationsOfSum {
    PrintUniqueCombinationsOfSum(){
        int[] arr = {1,2,3};
        printUniqueCombinationsOfSum(arr, new ArrayList<Integer>(), 0, 4);
    }

    public static void main(String[] args) {
        new PrintUniqueCombinationsOfSum();
    }

    private void printUniqueCombinationsOfSum(int[] arr,List<Integer> buffer,int index,int target){
                
        if(target==0) {
            System.out.println(buffer);
            return;
        }

       for(int i = index; i< arr.length;i++){
         if(i > index && arr[i] == arr[i-1]) continue;

         if(arr[i] > target) break;
         buffer.add(arr[i]);
         printUniqueCombinationsOfSum(arr, buffer, index+1, target-arr[i]);
         buffer.remove(buffer.size()-1);
       }

    }

}
