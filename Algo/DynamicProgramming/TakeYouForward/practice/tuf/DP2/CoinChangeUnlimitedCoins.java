package DP2;

import java.util.Arrays;

public class CoinChangeUnlimitedCoins {
    int[] coins = {1,2,5};
    int N= coins.length,TARGET=5;
    public static void main(String[] args) {
        new CoinChangeUnlimitedCoins();
    }

    CoinChangeUnlimitedCoins(){
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        System.out.println("Recursive : "+findTotalNumberCoins(coins, dp, N-1, TARGET));
        System.out.println("Iterative : "+findTotalNumberCoinsIterative(coins));
        System.out.println("Iterative Efficient: "+findTotalNumberCoinsIterativeEfficient(coins));
    }

    public int findTotalNumberCoins(int[] coins,int[][] dp,int index,int sum){
        if(index==0) {
            if(sum%coins[0]==0) return 1;
            else return 0;
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take =0,nontake =0;
        nontake = findTotalNumberCoins(coins, dp, index-1, sum);
        if(sum-coins[index]>=0)
        take = findTotalNumberCoins(coins, dp, index, sum-coins[index]);
        dp[index][sum]= take+nontake;
        return dp[index][sum];
    }

    public int findTotalNumberCoinsIterative(int[] coins){
        int[][] dp = new int[N][TARGET+1];
        for(int i=0;i<=TARGET;i++) dp[0][i]=i%coins[0]==0?1:0;
        //if(coins[0]<TARGET) dp[0][coins[0]]=1;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take =0,nontake =0;
                nontake = dp[index-1][sum];
                if(sum-coins[index]>=0)
                take = dp[index][sum-coins[index]];
                dp[index][sum]= take+nontake;
            }
        }
        
        return dp[N-1][TARGET];
    }

    public int findTotalNumberCoinsIterativeEfficient(int[] coins){
        int[] current = new int[TARGET+1];
        int[] previous = new int[TARGET+1];
        for(int i=0;i<=TARGET;i++) previous[i]=i%coins[0]==0?1:0;
        //if(coins[0]<TARGET) dp[0][coins[0]]=1;
        for(int index=1;index<N;index++){
            for(int sum=0;sum<=TARGET;sum++){
                int take =0,nontake =0;
                nontake = previous[sum];
                if(sum-coins[index]>=0)
                take = current[sum-coins[index]];
                current[sum]= take+nontake;
            }
            previous=current.clone();
        }
        
        return current[TARGET];
    }

    
}
