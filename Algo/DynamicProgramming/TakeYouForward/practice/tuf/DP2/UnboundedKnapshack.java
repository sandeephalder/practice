package DP2;

import java.util.Arrays;

public class UnboundedKnapshack {
    int[] profit = {7,2,4};
    int[] weight = {5,10,20};
    int maxWeight = 15,N= profit.length;
    public static void main(String[] args) {
        new UnboundedKnapshack();
    }

    UnboundedKnapshack(){
        int[][] dp = new int[N][maxWeight+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        System.out.println("Recursive "+findTheUnboundedKnapshackRecursive(profit, weight, dp, N-1, maxWeight));
        System.out.println("Iterative "+findTheUnboundedKnapshackIterative(profit, weight));
        System.out.println("Iterative Efficient "+findTheUnboundedKnapshackIterativeEfficient(profit, weight));
    }

    private int findTheUnboundedKnapshackRecursive(int[] profit,int[] weight,int[][] dp,int index,int wt){   
        if(index==0)
            return (wt/weight[0])*profit[0];
            
        if(dp[index][wt]!=-1) return dp[index][wt];
        int take=0,nontake=0;
        nontake = findTheUnboundedKnapshackRecursive(profit, weight, dp, index-1, wt);
        if(wt-weight[index]>=0)
        take = findTheUnboundedKnapshackRecursive(profit, weight, dp, index, wt-weight[index])+profit[index];
        //System.out.println(" take "+take+" nontake "+nontake);
        dp[index][wt]=Math.max(take, nontake);
        return dp[index][wt];
    }

     private int findTheUnboundedKnapshackIterative(int[] profit,int[] weight){   
        int[][] dp = new int[N][maxWeight+1];
        for(int wt=0;wt<=maxWeight;wt++) dp[0][wt]=(wt/weight[0])*profit[0];

        for(int index=1;index<N;index++){
            for(int wt=0;wt<=maxWeight;wt++){
                int take=0,nontake=0;
                nontake = dp[index-1][wt];
                if(wt-weight[index]>=0)
                take = dp[index][wt-weight[index]]+profit[index];
                //System.out.println(" take "+take+" nontake "+nontake);
                dp[index][wt]=Math.max(take, nontake);
            }
        }
        return dp[N-1][maxWeight];
    }

    private int findTheUnboundedKnapshackIterativeEfficient(int[] profit,int[] weight){   
        int[] previous = new int[maxWeight+1];
        int[] current = new int[maxWeight+1];
        for(int wt=0;wt<=maxWeight;wt++) previous[wt]=(wt/weight[0])*profit[0];

        for(int index=1;index<N;index++){
            for(int wt=0;wt<=maxWeight;wt++){
                int take=0,nontake=0;
                nontake = previous[wt];
                if(wt-weight[index]>=0)
                take = current[wt-weight[index]]+profit[index];
                //System.out.println(" take "+take+" nontake "+nontake);
                current[wt]=Math.max(take, nontake);
            }
            previous=current.clone();
        }
        return current[maxWeight];
    }

    
}



