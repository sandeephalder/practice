package DP2;

import java.util.Arrays;

public class MinimiumCoins {
    int[] coins = {1,2,5}; 
    int TARGET =19,N=coins.length,MAX=(int)(10e7);
    public static void main(String[] args) {
        new MinimiumCoins();
    }

    MinimiumCoins(){
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        System.out.println(" Recursive: "+coinChangeRecursive(coins,dp, N-1,TARGET,0));
        System.out.println(" Iterative: "+coinChangeRecursiveIterative(coins));
        System.out.println(" Iterative Efficient: "+coinChangeRecursiveIterativeEfficient(coins));
    }

    public int coinChangeRecursive(int[] coins,int[][] dp,  int index,int sum,int count) {
      
        if(index ==0){
            if(sum==0) return count;
            else if(sum==coins[index]) return count+1;
            else return MAX;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take=MAX,retake=MAX,nontake=MAX;
        if(sum-coins[index]>=0){
        retake = coinChangeRecursive(coins,dp,index, sum-coins[index], count+1);
        take = coinChangeRecursive(coins, dp,index-1, sum-coins[index], count+1);
        }
        nontake = coinChangeRecursive(coins, dp,index-1,sum ,count);
        //System.out.println(" take: "+take+" nontake: "+nontake+" retake: "+retake);
        dp[index][sum]=Math.min(take, Math.min(retake, nontake));
        return dp[index][sum];
    }

    public int coinChangeRecursiveIterative(int[] coins) {
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<=TARGET;i++) dp[0][i]=i/coins[0];
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take=MAX,retake=MAX,nontake=MAX;
                if(sum-coins[index]>=0){
                retake = dp[index][sum-coins[index]]+1;
                take = dp[index-1][sum-coins[index]]+1;
                }
                nontake = dp[index-1][sum];
                //System.out.println(" take: "+take+" nontake: "+nontake+" retake: "+retake);
                dp[index][sum]=Math.min(take, Math.min(retake, nontake));
            }
        }
        return dp[N-1][TARGET];
    }

       public int coinChangeRecursiveIterativeEfficient(int[] coins) {
        int[] current = new int[TARGET+1];
        int[] previous = new int[TARGET+1];
        for(int i=0;i<=TARGET;i++) previous[i]=i/coins[0];
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take=MAX,retake=MAX,nontake=MAX;
                if(sum-coins[index]>=0){
                retake = current[sum-coins[index]]+1;
                take = previous[sum-coins[index]]+1;
                }
                nontake = previous[sum];
                //System.out.println(" take: "+take+" nontake: "+nontake+" retake: "+retake);
                current[sum]=Math.min(take, Math.min(retake, nontake));
            }
            previous=current.clone();
        }
        return current[TARGET];
    }
}
