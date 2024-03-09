package DP2;

import java.util.Arrays;

public class CountPartitionsWithFixedSum {

    int arr[] = {0,0,1};
    int TARGET = 1;
    int N= arr.length;
    public static void main(String[] args) {
        new CountPartitionsWithFixedSum();
    }

    CountPartitionsWithFixedSum(){
        System.out.println("Recursive "+findWays(arr, TARGET));
        System.out.println("Iterative "+countSubsetSumIterative(arr));
        System.out.println("Iterative Efficient"+countSubsetSumIterativeEfficient(arr));
    }

    public int findWays(int num[], int tar) {
        
        int[][] buffer = new int[N][tar+1];
        for(int i=0;i<N;i++)
        for(int j=0;j<=tar;j++)
            buffer[i][j]=-1;
        return countSubsetSumRecuersive(buffer,num,N-1,tar);
    }

    private int countSubsetSumRecuersive(int[][] dp,int[] input,int index,int sum){
        if(sum==0) {
            return 1;
        }
        if(index==0) {
            if(sum==input[0]) return 1;
            return 0;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take =0,nontake=0;

        nontake = countSubsetSumRecuersive(dp, input, index-1, sum);
        if(sum-input[index]>=0)
        take = countSubsetSumRecuersive(dp, input, index-1, sum-input[index]);
        dp[index][sum]=take+nontake;
        return dp[index][sum];
    }

        private int countSubsetSumIterative(int[] input){
            int[][] dp = new int[N][TARGET+1];
            for(int i=0;i<N;i++) Arrays.fill(dp[i],0);
            for(int i=0;i<N;i++) dp[i][0]=1;
            if(input[0]<TARGET) dp[0][input[0]]=1;

            for(int index =1;index<N;index++){
                for(int sum =1 ;sum <=TARGET;sum++){
                    int take =0,nontake=0;
                    nontake = countSubsetSumRecuersive(dp, input, index-1, sum);
                    if(sum-input[index]>=0)
                    take = countSubsetSumRecuersive(dp, input, index-1, sum-input[index]);
                    dp[index][sum]=take+nontake;
                }
            }
       
        return dp[N-1][TARGET];
    }

    private int countSubsetSumIterativeEfficient(int[] input){
            int[] previous = new int[TARGET+1];
            int[] current = new int[TARGET+1];
            
            for(int i=0;i<N;i++) previous[0]=1;
            if(input[0]<=TARGET) previous[input[0]]=1;

            for(int index =1;index<N;index++){
                for(int sum =0 ;sum <=TARGET;sum++){
                    int take =0,nontake=0;
                    nontake = previous[sum];
                    if(sum-input[index]>=0)
                    take = previous[sum-input[index]];
                    current[sum]=take+nontake;
                }
                previous= current.clone();
            }
       
        return current[TARGET];
    }
    
}
