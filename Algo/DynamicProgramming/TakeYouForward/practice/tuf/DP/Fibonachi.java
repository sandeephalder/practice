package tuf.DP;

import java.util.Arrays;

public class Fibonachi {
    int N=10;
    int dp[] = new int[N+1];
    
    Fibonachi(){
      
        Arrays.fill(dp, -1);
        System.out.println(findFibonacciDP(N, dp));
        System.out.println(findFibonacciDPIterativeSpace(N));
    }

    public static void main(String[] args) {
        new Fibonachi();
    }

    private int findFibonacciDP(int val,int[] dp){
        if(val<2) return 1;
        if(dp[val]!=-1) return dp[val];

        dp[val] = findFibonacciDP(val-1,dp) + findFibonacciDP(val-2,dp);
        return dp[val];
    }

    private int findFibonacciDPIterative(int val){
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        dp[1]=1;
    
        for(int i=2;i<=val;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[val];
    }

    private int findFibonacciDPIterativeSpace(int val){
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        int current=0,prev=1,prev_prev=1;
    
        for(int i=2;i<=val;i++){
            current = prev+prev_prev;
            prev_prev=prev;
            prev=current;
        }
        return current;
    }
}
