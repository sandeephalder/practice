import java.util.ArrayList;
import java.util.List;

public class ArraySubsequence {
    

    public static void main(String[] args) {
        new ArraySubsequence();    
       }
   
       ArraySubsequence(){
           int[] arr = {3,1,2};
           int N = arr.length;
           findSubsequence(arr,new ArrayList<>(), 0);
       }
   
       public void findSubsequence(int[] arr,List<Integer> list,int index){
           int N = arr.length;
           if(index>=N) {
            System.out.println(" index"+index+" 1=> "+list);
            return;
           }

           list.add(arr[index]);
           findSubsequence(arr, list, index+1);
           
           list.remove(list.size()-1);
           findSubsequence(arr, list, index+1);
       }

   
   }