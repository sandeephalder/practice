package DP2;

import java.util.Arrays;

public class KnapShak1 {
    int[] weight = {1,2,4,5};
    int[] value = {5,4,8,6};
    int weightMax=5,N=weight.length,MIN=(int)-10e5,MAX_WEIGHT= Arrays.stream(weight).max().getAsInt()+1;
    
    public static void main(String[] args) {
        new KnapShak1();
    }

    KnapShak1(){
        int[][] dp = new int[N][MAX_WEIGHT];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+findKnapShack(weight, value, weightMax,0, N-1,dp));
        System.out.println(" Iterative: "+findKnapShackIterative(weight, value));
        System.out.println(" Iterative Efficient: "+findKnapShackIterativeEfficient(weight, value));
    }

    public int findKnapShack(int[] weight,int[] value,int currentWeight,int currentValue,int index,int[][] dp){
        if(currentWeight<0) return currentValue;
        if(index<0){
            return currentValue;
        }
       if(dp[index][currentWeight]!=-1) return dp[index][currentWeight];
        int take=MIN,nontake=MIN;
        nontake = findKnapShack(weight, value, currentWeight,currentValue, index-1,dp);
        if(currentWeight-weight[index]>=0)
        take = findKnapShack(weight, value, currentWeight-weight[index],currentValue+value[index], index-1,dp);
        dp[index][currentWeight] = Math.max(take,nontake);
        return dp[index][currentWeight];
    }

     public int findKnapShackIterative(int[] weight,int[] value){
        int[][] dp = new int[N][MAX_WEIGHT+1];
        for(int i=weight[0];i<MAX_WEIGHT;i++) dp[0][i]=value[0];
        
        for(int index=1;index<N;index++){
            for(int currentWeight=0;currentWeight<=MAX_WEIGHT;currentWeight++){
                int take=MIN,nontake=MIN;
                nontake = dp[index-1][currentWeight];
                if(currentWeight-weight[index]>=0)
                take = dp[index-1][currentWeight-weight[index]] + value[index];
                dp[index][currentWeight] = Math.max(take,nontake);
            }
        }
        return dp[N-1][MAX_WEIGHT];
    }

     public int findKnapShackIterativeEfficient(int[] weight,int[] value){
        int[] current = new int[MAX_WEIGHT+1];
        int[] previous = new int[MAX_WEIGHT+1];
        for(int i=weight[0];i<MAX_WEIGHT;i++) previous[i]=value[0];
        
        for(int index=1;index<N;index++){
            for(int currentWeight=0;currentWeight<=MAX_WEIGHT;currentWeight++){
                int take=MIN,nontake=MIN;
                nontake = previous[currentWeight];
                if(currentWeight-weight[index]>=0)
                take = previous[currentWeight-weight[index]] + value[index];
                current[currentWeight] = Math.max(take,nontake);
            }
            previous=current.clone();
        }
        return current[MAX_WEIGHT];
    }
}
