package tuf.DP;

import java.util.Arrays;

public class ClimbingStairs {
    int N= 4;
    int[] dp = new int[N+1];
    ClimbingStairs(){
        Arrays.fill(dp,-1);
        
        System.out.println(climbStairs(N, dp));
    }

    public static void main(String[] args) {
        new ClimbingStairs();
    }

    private int climbStairs(int stairs,int[] dp){
        if(stairs<2) return 1;
        if(dp[stairs]!=-1) return dp[stairs];
        dp[stairs] = climbStairs(stairs-1,dp)+climbStairs(stairs-2,dp);
        return dp[stairs];
    }
}
