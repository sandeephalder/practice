package DP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLongestIncreasingSubsequence {
    int[] sequence ={5, 6, 3, 4, 7, 6};
   //int[] sequence ={2, 5, 7, 9, 6, 8};
    int N= sequence.length;
    public static void main(String[] args) {
        new PrintLongestIncreasingSubsequence();
    }

    PrintLongestIncreasingSubsequence(){
        List<List<Integer>> result = new ArrayList<>(); 
        findLongestIncreasingSubsequence(sequence, 0, new ArrayList<Integer>(), result,-1);
        //System.out.println("Recursive : "+result);
         System.out.println("Iterative1: "+findLongestIncreasingSubsequenceIterative1(sequence));
         System.out.println("Iterative2: "+findLongestIncreasingSubsequenceIterative2(sequence));
        // test();
    }

private void findLongestIncreasingSubsequence(int[] sequence,int index,
    List<Integer> plane,List<List<Integer>> result,int previous){
        
        if(index>=sequence.length){
            result.add(new ArrayList<>(plane));
            return;
        }
        if(previous==-1 || sequence[index]>sequence[previous]){
            plane.add(sequence[index]);
            findLongestIncreasingSubsequence(sequence, index+1, plane, result, index);
            plane.remove(plane.size()-1);
        }

        findLongestIncreasingSubsequence(sequence, index+1, plane, result, previous);
    }

    private int findLongestIncreasingSubsequenceIterative1(int[] sequence){
        
       int N = sequence.length,max=-(int)(10e7);
       int[] dp = new int[N];
       Arrays.fill(dp, 1);
       for(int i=1;i<N;i++){
         for(int j=0;j<i;j++){
            if(sequence[i]>sequence[j]){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
         }
       }
       for(int i=0;i<N;i++) if(dp[i]>max) max = dp[i];

       return max;
    }

       private int findLongestIncreasingSubsequenceIterative2(int[] sequence){
        
       int N = sequence.length,result=1;;
       int[] dp = new int[N];
       Arrays.fill(dp, 0);
       if(N>1)
       for(int i=1;i<N-1;i++){
        if(sequence[i+1]<sequence[i])
        binarySearch(dp, i,sequence[i+1] );
        else{
            dp[i+1]= sequence[i+1];
            result++;
        }
       }
      
       return result;
    }

   private void test(){
         int[] dp = new int[N];
         int index=4;
         for(int i=0;i<index;i++) dp[i]=sequence[i];
         binarySearch(dp, index, 11);
   }

   public void print(int arr[]){
     System.out.println();
     for(int i=0;i<arr.length;i++) System.out.print(" ==> "+arr[i]);
   }
    
   private int binarySearch(int[] dp,int index,int value){
        print(dp);
        if(index>=dp.length) return 2;
        if(value>dp[index]) {
            dp[index+1]=value;
        }
        int lo=0,hi=index,mid=0;
        while(hi>=lo){
            mid = (lo+hi)/2;
            if(value<=dp[mid]){
                hi= mid-1;
            }
            else lo = mid+1;
        }
        System.out.println("\nValue = "+value+" lo = "+lo+" mid= "+mid+" hi= "+hi);
        dp[lo]=value;
        print(dp);
        
        return 3;
   }

}
