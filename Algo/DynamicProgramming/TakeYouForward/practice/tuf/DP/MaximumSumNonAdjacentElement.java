package tuf.DP;

import java.util.Arrays;

public class MaximumSumNonAdjacentElement {
    int[] list = {1, 2 ,3, 1 ,3 ,5, 8 ,1 ,9};
    int[] dp = new int[list.length];
    MaximumSumNonAdjacentElement(){
        Arrays.fill(dp,-1);
        System.out.println(maximumSumNonAdjacentElement(list,dp,list.length-1));
        System.out.println(maximumSumNonAdjacentElementIterative(list,list.length-1));
        System.out.println(maximumSumNonAdjacentElementIterativeSpaceOptimized(list,list.length-1));
    }

    public static void main(String[] args) {
        new MaximumSumNonAdjacentElement();
    }

    private int maximumSumNonAdjacentElement(int[] list,int[] dp,int n){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        dp[n] = Math.max(maximumSumNonAdjacentElement(list,dp, n-2) + list[n],maximumSumNonAdjacentElement(list, dp,n-1));
       return dp[n];
    }
    private int maximumSumNonAdjacentElementIterative(int[] list,int N){
        Arrays.fill(dp,0);
        dp[0]=list[0];
        for(int n=1;n<=N;n++){
            dp[n] = Math.max(n-2>=0?dp[n-2]+ list[n]:0 ,dp[n-1]);
        }
        
       return dp[N];
    }

    private int maximumSumNonAdjacentElementIterativeSpaceOptimized(int[] list,int N){
        int current=0,prev=dp[0]=list[0],prev2=0;
       
        for(int n=1;n<=N;n++){
            current = Math.max(n-2>=0?prev2+ list[n]:0 ,prev);
            prev2=prev;
            prev=current;
        }
        
       return current;
    }
  
}
