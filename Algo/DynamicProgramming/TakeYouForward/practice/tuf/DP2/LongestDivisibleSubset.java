package DP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {

    int[] subset ={8,80,2,10,5,4,64,128,40,1,20,32,16};
    int N= subset.length;

    public static void main(String[] args) {
        new LongestDivisibleSubset();
    }

    LongestDivisibleSubset(){
        Arrays.sort(subset);
        new PrintLongestIncreasingSubsequence().print(subset);
        List<Integer> result = new ArrayList<>();
        int[][] dp = new int[N][N+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println("\n Recursive: "+findLongestDivisibleSubsetRecursive(subset, N-1,-1, result,dp));
    }

    private int findLongestDivisibleSubsetRecursive(int[] subset,int index,int last,List<Integer> stage,int[][] dp){
        if(index<0){
            return 0;
        }
        int l1=0,l2=0;
        if(dp[index][last+1]!=-1) return dp[index][last+1];
        l1= findLongestDivisibleSubsetRecursive(subset, index-1,last, stage,dp);
        if((last ==-1&&stage.size()==0) || (subset[index]<subset[last] && subset[last]%subset[index]==0)){
           
            stage.add(subset[index]);
            
            l2= findLongestDivisibleSubsetRecursive(subset, index-1,index, stage,dp);
            stage.remove((int)stage.size()-1);
            l2++;
        }

        if (l1>l2) dp[index][last+1] =l1;
        else dp[index][last+1]= l2;

        return dp[index][last+1];
    }
}
