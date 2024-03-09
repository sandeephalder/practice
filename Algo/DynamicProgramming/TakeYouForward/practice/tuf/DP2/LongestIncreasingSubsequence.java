package DP2;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int[] nums = {10,9,2,5,3,7,101,18};
    int N= nums.length,MIN=-(int)(10e7);
    public static void main(String[] args) {
        new LongestIncreasingSubsequence();
    }

    LongestIncreasingSubsequence(){
        
        int[][] dp = new int[N][N+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i], -1);
        System.out.println(" Recursive: "+lengthOfLISRecursive(nums, 0, dp, -1));
        System.out.println(" Iterative: "+lengthOfLISIterative(nums));
        System.out.println(" Iterative Efficient: "+lengthOfLISIterativeEfficient(nums));
    }

    public int lengthOfLISRecursive(int[] nums,int index,int[][] dp,int prev) {
        if(index==N-1) {
            return 0;
        }
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int take=MIN,nontake=MIN;
        nontake = lengthOfLISRecursive(nums, index+1, dp, prev);
        if(prev==-1 || nums[index]>nums[prev]){
        
            take= lengthOfLISRecursive(nums, index+1, dp, index)+1;
        }
        dp[index][prev+1]= Math.max(take,nontake); 
        return dp[index][prev+1];
    }

    public int lengthOfLISIterative(int[] nums) {
        int[][] dp = new int[N+1][N+1];
        for(int index=N-1;index>=0;index--){
            for(int prev=index-1;prev>=-1;prev--){
                            int take=MIN,nontake=MIN;
                            nontake = dp[index+1][prev+1];
                            if(prev==-1 || nums[index]>nums[prev]){
                                take= dp[index+1][index+1]+1;
                            }
                            dp[index][prev+1]= Math.max(take,nontake); 
            }
        }
        
        return dp[0][0];
    }

     public int lengthOfLISIterativeEfficient(int[] nums) {
        int[] current = new int[N+1];
        int[] next = new int[N+1];
        for(int index=N-1;index>=0;index--){
            for(int prev=index-1;prev>=-1;prev--){
                            int take=MIN,nontake=MIN;
                            nontake = next[prev+1];
                            if(prev==-1 || nums[index]>nums[prev]){
                                take= next[index+1]+1;
                            }
                            current[prev+1]= Math.max(take,nontake); 
            }
            next=current.clone();
        }
        
        return next[0];
    }
}
